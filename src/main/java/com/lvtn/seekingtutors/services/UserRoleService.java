package com.lvtn.seekingtutors.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvtn.seekingtutors.models.Role;
import com.lvtn.seekingtutors.repository.UserRoleRepository;

@Component
@Transactional
public class UserRoleService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	List<Role> getAllRoleByUserId (int userId)
	{
		return userRoleRepository.getAllRoleByUserId(userId);
	}
}
