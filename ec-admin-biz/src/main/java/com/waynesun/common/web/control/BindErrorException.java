/**
 * 
 */
package com.waynesun.common.web.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.waynesun.exception.BizException;

/**
 * Title: Ivy<br>
 * Description:SGMW<br>
 * create date：2012-5-10<br>
 * 
 * @author sunmin
 * @version: 0.1
 */
public class BindErrorException extends BizException
{
	private static final long serialVersionUID = 3650375683819262170L;

	private Map<String, String> errors = new HashMap<String, String>();

	public static String DEFALUT_BIND_ERROR_KEY = "errors.bind";

	public BindErrorException()
	{
		super(DEFALUT_BIND_ERROR_KEY);
	}

	public BindErrorException(String errorCode)
	{
		super(errorCode);
	}

	public BindErrorException(Map<String, String> errors)
	{
		this();
		this.errors = errors;
	}

	public BindErrorException(String errorCode, Map<String, String> errors)
	{
		super(errorCode);
		this.errors = errors;
	}

	public void setErrors(Map<String, String> errors)
	{
		this.errors = errors;
	}

	public String getMessage()
	{
		String message = super.getMessage();
		if (errors != null && errors.size() > 0)
			message += ": ";
		for (Entry<String, String> entry : errors.entrySet())
		{
			message += entry.getKey() + " " + entry.getValue() + "<br/>";
		}
		return message;
	}
}
