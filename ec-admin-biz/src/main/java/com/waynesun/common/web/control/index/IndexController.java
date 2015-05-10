package com.waynesun.common.web.control.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waynesun.exception.NoUserException;

@Controller
public class IndexController
{
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index()
	{
		return "/login.jsp";
	}

	@RequestMapping(value = "/invalidSsession")
	public String invalidSsession()
	{
		//System.out.println("--------------------------------");
		throw new NoUserException();
	}
}
