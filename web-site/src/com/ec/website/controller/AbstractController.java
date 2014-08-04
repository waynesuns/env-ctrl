package com.ec.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.SolutionParam;

public abstract class AbstractController {


	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response){
		
		SolutionParam param = this.generateParam(1);

		request.setAttribute("solutionParam", param);
		return "/template/2ndIndex.jsp";
	}
	
	public abstract SolutionParam generateParam(int subItemIndex);
}
