package com.waynesun.common.web.control.index;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.user.LoginAccount;
import com.waynesun.common.biz.user.LoginAccountQC;
import com.waynesun.common.biz.user.LoginAccountUtils;
import com.waynesun.common.biz.user.LoginException;
import com.waynesun.common.web.control.AbstractBindController;

@Controller
@RequestMapping(value = "/login")
public class LoginController extends AbstractBindController
{
	/**
	 * 进入登陆页面
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String state = request.getParameter("state");
		if ("1".equals(state)) {
			request.setAttribute("state", state);
		} else {
			request.removeAttribute("state");
		}

		AuthenticationException exception =(AuthenticationException)request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if(exception==null)
			exception = (AuthenticationException)request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		else
			request.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if(exception!=null){
			request.setAttribute("loginErrorMessage", exception.getMessage());
			request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}

		return "/login.jsp";
	}
	/**
	 * 登陆操作
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public String login(HttpServletRequest request, LoginAccountQC qc) throws Exception
	{
		if (StringUtils.isEmpty(qc.getUserName()) && StringUtils.isEmpty(qc.getPassword()))
			throw LoginException.EMPTY_ERROR;
		LoginAccount account = LoginAccountUtils.findLoginAccount(qc);
		if (account == null)
			throw LoginException.NAME_OR_PASSWORD_ERROR;
		account.setLastTime(new Date());
		account.update();
		return ajaxJsonSuccessMessage("role.do");
	}

	@RequestMapping(value = "/show.do")
	public String loginShow()
	{
		return ".main~/bbs/newest.jsp";
	}
}
