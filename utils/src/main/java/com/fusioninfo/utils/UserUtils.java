package com.fusioninfo.utils;

import com.fusioninfo.exception.NoUserException;
import com.fusioninfo.pojo.User;


/**
 * 
 * @author weisun
 *
 */
public class UserUtils
{
	private static ThreadLocal<User> instance = new ThreadLocal<User>();
	
	public static final void setUser(User user)
	{
		instance.set(user);
	}

	/**
	 * 得到当前threadLocal中的用户，如果是null, 抛出NoUserException异常
	 * @return
	 */
	public static final User getUser()
	{
		User user = instance.get();
		if (user == null)
			throw new NoUserException();
		return instance.get();
	}

}
