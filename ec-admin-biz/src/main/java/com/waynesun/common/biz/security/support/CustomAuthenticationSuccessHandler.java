package com.waynesun.common.biz.security.support;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.waynesun.utils.UserUtils;
import com.waynesun.common.biz.log.OperateLog;
import com.waynesun.common.biz.log.OperateLogType;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.LoginAccount;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
	private String targetUrl;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException
	{
		Object obj = authentication.getPrincipal();
		LoginAccount account = (LoginAccount) obj;
		AbstractUser user = account.getUser();
		UserUtils.setUser(user);
		account.setLastTime(new Date());
		account.update();
		OperateLog.getInstance(user, OperateLogType.LOGIN).saveOperateLog();
		request.getRequestDispatcher(targetUrl).forward(request, response);
	}

	public String getTargetUrl()
	{
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl)
	{
		this.targetUrl = targetUrl;
	}
}