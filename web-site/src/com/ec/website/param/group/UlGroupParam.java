package com.ec.website.param.group;

import java.util.ArrayList;
import java.util.List;

public class UlGroupParam extends AbstractGroupParam<UlGroupParam,String>{
	private List<String> values = new ArrayList<String>();
	public UlGroupParam(String title) {
		super("ul", title);
	}

	@Override
	public String getTemplatePath() {
		return "ul.jsp";
	}
	
	public UlGroupParam addValue(String value){
		this.values.add(value);
		return this;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

}
