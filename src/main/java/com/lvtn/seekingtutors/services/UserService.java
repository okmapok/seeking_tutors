package com.lvtn.seekingtutors.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvtn.seekingtutors.models.User;
import com.lvtn.seekingtutors.repository.UserRepository;

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
	
}
