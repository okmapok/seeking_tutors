package com.lvtn.seekingtutors.repository;

import com.lvtn.seekingtutors.models.User;
import com.lvtn.seekingtutors.query.UserSqlQuery;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query(value=UserSqlQuery.AUTHENTICATE_QUERY)
	public List<User> authenticate(@Param("email") String email, @Param("password") String password);
	
	public List<User> findByEmail (String email);
}
