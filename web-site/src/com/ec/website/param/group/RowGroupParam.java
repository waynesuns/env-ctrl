package com.ec.website.param.group;


public class RowGroupParam extends MainGroupParam  {

	public RowGroupParam(String type, String title) {
		super(type, title);
	}

	@Override
	public String getTemplatePath() {
		// TODO Auto-generated method stub
		return "row.jsp";
	}
	
}
