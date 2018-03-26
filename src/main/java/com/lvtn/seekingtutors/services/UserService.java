package com.lvtn.seekingtutors.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvtn.seekingtutors.Constant.ConstantKeys;
import com.lvtn.seekingtutors.models.User;
import com.lvtn.seekingtutors.repository.UserRepository;
import com.lvtn.seekingtutors.utility.EncrytedPasswordUtils;

import javassist.NotFoundException;

import org.json.JSONException;
import org.json.JSONObject;

@Component
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) throws Exception
	{
		try {
			userRepository.save(user);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public User findByEmail (String email)
	{
		List<User> users = null;
		try {
			users = userRepository.findByEmail(email);
			if (!users.isEmpty())
			{
				return users.get(0);
			}
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public JSONObject authenticate (String email, String password) throws NotFoundException, JSONException
	{
		User user = findByEmail(email);
		JSONObject response = new JSONObject();
		if (user != null)
		{
			String bcrytedPassword = user.getBcrytPassword();
			Boolean checkAuthentication = EncrytedPasswordUtils.checkPassWord(password, bcrytedPassword);
			if (checkAuthentication)
			{
				response.put(ConstantKeys.EMAIL, email);
				response.put(ConstantKeys.RESPONSE_CODE, 200);
				response.put(ConstantKeys.STATUS, ConstantKeys.SUCCESS);
				response.put(ConstantKeys.RESPONSE_MESSAGE, ConstantKeys.OK);
			}
			else {
				response.put(ConstantKeys.EMAIL, email);
				response.put(ConstantKeys.RESPONSE_CODE, 401);
				response.put(ConstantKeys.STATUS, ConstantKeys.FAIL);
				response.put(ConstantKeys.RESPONSE_MESSAGE, ConstantKeys.ERROR);
			}
			return response;
		}
		else {
			throw new NotFoundException("The user is not found");
		}
		
	}
}
