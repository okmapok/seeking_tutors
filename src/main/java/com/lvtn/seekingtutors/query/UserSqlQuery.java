package com.lvtn.seekingtutors.query;

public class UserSqlQuery {
	
	private UserSqlQuery()
	{
		super();
	}
	public static final String AUTHENTICATE_QUERY = " SELECT (u) FROM User u"
			+ " WHERE u.email = :email AND u.bcrytPassword = :password";

}
