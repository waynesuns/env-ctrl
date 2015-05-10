package com.waynesun.common.biz.security.interceptor;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

import com.waynesun.utils.UserUtils;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.LoginAccount;

public class RequestHeaderProcessingFilter extends SecurityContextHolderAwareRequestFilter implements Observer
{
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		LoginAccount account = null;
		if (authentication != null)
			account = (LoginAccount) authentication.getPrincipal();
		if (account != null)
		{
			AbstractUser user = account.getUser();
			user.addObserver(this);
			UserUtils.setUser(user);
			req.setAttribute("user", user);
		}
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)res;
				String curUrl = request.getServletPath();
		System.out.println(curUrl);
			super.doFilter(request, response, chain);
		
	}

	/* (非 Javadoc) 
	 * <p>Title: update</p> 
	 * <p>Description: </p> 
	 * @param o
	 * @param arg 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object) 
	 */
	@Override
	public void update(Observable o, Object arg) {
		AbstractUser user = (AbstractUser)arg;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		LoginAccount account = null;
		
		if (authentication != null)
			account = (LoginAccount) authentication.getPrincipal();
		if (account != null && account.getUser().getId().equals(user.getId()))
		{
			account.setUser(user);
			UserUtils.setUser(user);
		}
		
	}
}