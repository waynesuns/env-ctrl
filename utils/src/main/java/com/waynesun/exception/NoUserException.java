/**
 * 
 */
package com.waynesun.exception;

import com.waynesun.utils.MessageReader;

/**
 * @author Administrator
 *
 */
public class NoUserException extends RuntimeException 
{
	public static final String ERROSR_NO_USER = "errors.noUser";

	private static final long serialVersionUID = 8378666307458610166L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return MessageReader.getMessage(ERROSR_NO_USER);
	}
	
	
}
