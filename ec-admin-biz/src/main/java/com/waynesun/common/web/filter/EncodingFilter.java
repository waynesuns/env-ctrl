/**
 * 
 */
package com.waynesun.common.web.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author Administrator
 *
 */
public class EncodingFilter extends CharacterEncodingFilter
{
	private String invalidPath;
	
	
	public void setInvalidPath(String path)
	{
		this.invalidPath = path;
	}

	
	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#shouldNotFilter(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException
	{
		if(request.isRequestedSessionIdFromURL())
			request.getSession().invalidate();
		
		String path = request.getServletPath();
		if(invalidPath!=null && invalidPath.indexOf(path)>=0)
		{
			return true;
		}
		return super.shouldNotFilter(request);
	}

	

}
