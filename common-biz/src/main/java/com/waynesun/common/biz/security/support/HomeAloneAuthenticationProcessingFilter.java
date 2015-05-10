package com.waynesun.common.biz.security.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class HomeAloneAuthenticationProcessingFilter extends UsernamePasswordAuthenticationFilter
{

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException
	{
		return super.attemptAuthentication(request, response);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException,
			ServletException
	{
//		Object obj = authResult.getPrincipal();
//		if(obj instanceof LoginAccount)
//		{
//			LoginAccount account = (LoginAccount) obj;
//		}
		super.successfulAuthentication(request, response, authResult);
	}

}
