package com.lvtn.seekingtutors.query;

public class UserRoleSqlQuery {
	private UserRoleSqlQuery()
	{
		super();
	}
	
	public static final String GET_ALL_ROLE_BY_USER_ID_QUERY = " SELECT (r) FROM Role r"
			+ " WHERE r.id IN "
			+ " (SELECT ur.role.id FROM UserRole ur WHERE ur.user.id = :userId)";
}
