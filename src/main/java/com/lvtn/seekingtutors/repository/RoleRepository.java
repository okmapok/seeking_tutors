package com.lvtn.seekingtutors.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lvtn.seekingtutors.models.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{	
	public List<Role> findByName (String name);
}
