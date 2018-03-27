package com.lvtn.seekingtutors.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvtn.seekingtutors.models.Role;
import com.lvtn.seekingtutors.repository.RoleRepository;

@Component
@Transactional
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public Role findByName (String name) 
	{
		List<Role> roles = roleRepository.findByName(name);
		if(!roles.isEmpty())
		{
			return roles.get(0);
		}
		return null;
	}
}
