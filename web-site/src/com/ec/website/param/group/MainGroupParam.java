package com.ec.website.param.group;

import java.util.ArrayList;
import java.util.List;

public class MainGroupParam extends AbstractGroupParam<MainGroupParam,AbstractGroupParam<?,?>> {
	private List<AbstractGroupParam<?,?>> values = new ArrayList<AbstractGroupParam<?,?>>();
	private String desc;
	
	public MainGroupParam(String title,String desc) {
		super("main", title);
		this.desc = desc;
	}
	
	public MainGroupParam addValue(AbstractGroupParam<?,?> value){
		values.add(value);
		return this;
	}

	@Override
	public String getTemplatePath() {
		// TODO Auto-generated method stub
		return "main.jsp";
	}

	@Override
	public List<AbstractGroupParam<?,?>> getValues() {
		// TODO Auto-generated method stub
		return values;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setValues(List<AbstractGroupParam<?, ?>> values) {
		this.values = values;
	}

}
