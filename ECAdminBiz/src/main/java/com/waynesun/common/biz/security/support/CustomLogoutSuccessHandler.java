package com.waynesun.common.biz.security.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.waynesun.utils.UserUtils;
import com.waynesun.common.biz.log.OperateLog;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.LoginAccount;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler
{
	private String targetUrl;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
	{
		if(authentication == null)
		{
			response.sendRedirect(targetUrl);
			return;
		}
		Object obj = authentication.getPrincipal();
		if(obj instanceof LoginAccount)
		{
			LoginAccount account = (LoginAccount) obj;
			AbstractUser user = account.getUser();
			UserUtils.setUser(user);
			OperateLog.getInstance(user, com.waynesun.common.biz.log.OperateLogType.LOGINOUT).saveOperateLog();
		}
		response.sendRedirect(targetUrl);
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
