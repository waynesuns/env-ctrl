package com.waynesun.common.biz.user;

import com.waynesun.exception.BizException;

public class LoginException extends BizException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547716985962024817L;
	
	/** 用户名或密码错误 */
	public static LoginException NAME_OR_PASSWORD_ERROR = new LoginException("error.login.nameOrPassword");
	/** 用户名或密码不能为空 */
	public static LoginException EMPTY_ERROR = new LoginException("error.login.empty");
	
	public LoginException(String errorCode)
	{
		super(errorCode);
	}
}
