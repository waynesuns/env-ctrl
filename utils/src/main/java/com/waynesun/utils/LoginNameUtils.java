/**
 * 
 */
package com.waynesun.utils;

/**
 * @author Administrator
 * dynatecs-common
 * 2011-5-15
 */
public class LoginNameUtils
{
	public static boolean isValid(String name)
	{
		if(name.indexOf("@")<0)
			return false;
		return true;
	}
	
	public static String getAreaName(String name)
	{
		if(isValid(name))
			return name.substring(name.indexOf("@")+1, name.length());
		return null;
	}
	
	public static String getName(String email)
	{
		if(isValid(email))
			return email.substring(0, email.indexOf("@"));
		return null;
	}
}
