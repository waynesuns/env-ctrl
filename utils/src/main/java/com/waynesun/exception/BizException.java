package com.waynesun.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.waynesun.utils.MessageReader;

/**
 * Title: 宝冶二期<br>
 * Description:<br>
 * Copyright: Copyright (c) Steel Bright Intelligence 2006<br>
 * Company: 1703 Studio<br>
 * create date：2006-5-31<br>
 * 业务异常处理
 * 
 * @author 孙敏
 * @version: 1.0
 */
public class BizException extends RuntimeException
{
	private static final long serialVersionUID = -6030819121060980700L;
	
	protected final Log logger = LogFactory.getLog(this.getClass());

	/** 异常信息参数 */
	private String[] params;

	private String errorCode;

	/**
	 * 业务异常处理构造函数
	 * 
	 * @param errorCode 异常代码，自己到message.properties去看
	 * @param cause 异常
	 */
	public BizException(String errorCode, Throwable cause)
	{
		super(cause);
		this.errorCode = errorCode;
	}

	/**
	 * 业务异常处理构造函数
	 * 
	 * @param errorCode 异常代码，自己到message.properties去看
	 * @param params 异常信息参数，自己到message.properties去看
	 * @param cause 异常
	 */
	public BizException(String errorCode, String[] params, Throwable cause)
	{
		super(cause);
		this.errorCode = errorCode;
		setParams(params);
	}

	/**
	 * 业务异常处理构造函数
	 * 
	 * @param errorCode 异常代码，自己到message.properties去看
	 */
	public BizException(String errorCode)
	{
		this.errorCode = errorCode;
	}

	/**
	 * 业务异常处理构造函数
	 * 
	 * @param errorCode 异常代码，自己到message.properties去看
	 * @param params 异常信息参数，自己到message.properties去看
	 */
	public BizException(String errorCode, String... params)
	{
		setParams(params);
		this.errorCode = errorCode;
	}

	/**
	 * 业务异常处理构造函数
	 * 
	 * @param cause 异常
	 */
	public BizException(Throwable cause)
	{
		super(cause);
	}

	public String[] getParams()
	{
		return params;
	}

	private void setParams(String... params)
	{
		this.params = params;
	}

	private String getErrorCode()
	{
		return errorCode;
	}

	@Override
	public String getMessage()
	{
		logger.debug("getMessage:" + getErrorCode());
		return MessageReader.getMessage(getErrorCode(), params);
	}

}
