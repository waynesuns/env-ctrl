package com.waynesun.utils;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {

	public static boolean isIE(HttpServletRequest request)
	{
		if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0)
			return true;
		return false;
	}
}
