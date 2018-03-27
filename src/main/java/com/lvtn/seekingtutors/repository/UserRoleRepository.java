package com.lvtn.seekingtutors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lvtn.seekingtutors.models.Role;
import com.lvtn.seekingtutors.models.UserRole;
import com.lvtn.seekingtutors.query.UserRoleSqlQuery;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer>{
	@Query(value=UserRoleSqlQuery.GET_ALL_ROLE_BY_USER_ID_QUERY)
	public List<Role> getAllRoleByUserId (@Param("userId") int userId);
}
