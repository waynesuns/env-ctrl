package com.waynesun.common.web.control.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waynesun.common.web.control.AbstractController;
@Controller
@RequestMapping("/demo")
public class DemoController extends AbstractController{
	@RequestMapping(value="/show/home.do",method=RequestMethod.GET)
	public String home(){
		return ".main~/demo/home.jsp";
	}
}
