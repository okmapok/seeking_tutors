package com.lvtn.seekingtutors.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvtn.seekingtutors.Constant.ConstantKeys;
import com.lvtn.seekingtutors.models.Role;
import com.lvtn.seekingtutors.models.User;
import com.lvtn.seekingtutors.utility.EncrytedPasswordUtils;

import javassist.NotFoundException;

@Component
@Transactional
public class AuthService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	public JSONObject authenticate (String email, String password) throws NotFoundException, JSONException
	{
		User user = userService.findByEmail(email);
		JSONObject response = new JSONObject();
		if (user != null)
		{
			String encrytedPassword = user.getEncrytedPassword();
			Boolean checkAuthentication = EncrytedPasswordUtils.checkPassWord(password, encrytedPassword);
			if (checkAuthentication)
			{
				response.put(ConstantKeys.EMAIL, email);
				response.put(ConstantKeys.RESPONSE_CODE, 200);
				response.put(ConstantKeys.STATUS, ConstantKeys.SUCCESS);
				response.put(ConstantKeys.RESPONSE_MESSAGE, ConstantKeys.OK);
				List<Role> roles = userRoleService.getAllRoleByUserId(user.getId());
				List<String> roleNames = new ArrayList<>();
				for(Role role : roles)
				{
					roleNames.add(role.getName());
				}
				response.put(ConstantKeys.ROLES, roleNames);
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
