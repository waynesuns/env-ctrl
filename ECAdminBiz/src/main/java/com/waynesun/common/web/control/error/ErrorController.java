package com.waynesun.common.web.control.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waynesun.common.web.control.AbstractController;

/**
 * 异常处理Controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/")
public class ErrorController extends AbstractController
{
	@RequestMapping(value = "500")
	public String internalError(HttpServletRequest request, HttpServletResponse response)
	{
		return "/errors/500.jsp";
	}

	@RequestMapping(value = "404")
	public String notfoundError(HttpServletRequest request, HttpServletResponse response)
	{
		return "/errors/404.jsp";
	}

	@RequestMapping(value = "403")
	public String notPermission()
	{
		return "/errors/403.jsp";
	}

	@RequestMapping(value = "401")
	public String notLogged()
	{
		return "/errors/401.jsp";
	}
	
	@RequestMapping(value = "error")
	public String error(HttpServletRequest request, HttpServletResponse response)
	{
		return "/errors/error.jsp";
	}
}
