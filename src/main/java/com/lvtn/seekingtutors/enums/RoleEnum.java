package com.lvtn.seekingtutors.enums;

/**
 * Define Role name.
 */
public enum RoleEnum
{
  ADMINISTRATOR ("Administrator"),
  STAFF("Staff"),
  TUTOR ("Tutor"),
  STUDENT("Student"),
  GUEST("Guest");
  
  private String name;

  private RoleEnum(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public static RoleEnum getByRoleName(String roleName)
  {
    for (RoleEnum role : values())
    {
      if (role.getName().equals(roleName))
      {
        return role;
      }
    }
    return null;
  }
}
