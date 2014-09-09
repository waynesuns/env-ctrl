package com.ec.website.param.group;

public class OlGroupParam extends UlGroupParam{

	public OlGroupParam(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getTemplatePath() {
		return "ol.jsp";
	}
}
