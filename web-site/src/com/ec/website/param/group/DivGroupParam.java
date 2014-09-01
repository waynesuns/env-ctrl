package com.ec.website.param.group;

import java.util.ArrayList;
import java.util.List;

import com.ec.website.param.DivParam;

public class DivGroupParam extends AbstractGroupParam<DivGroupParam,DivParam>{
	private List<DivParam> values = new ArrayList<DivParam>();
	private String desc;
	private String subTitle;
	public DivGroupParam(String title,String desc) {
		super("div", title);
		this.desc = desc;
	}
	public DivGroupParam(String title,String desc,String subTitle) {
		super("div", title);
		this.desc = desc;
		this.subTitle = subTitle;
	}
	@Override
	public String getTemplatePath() {
		return "div.jsp";
	}
	
	public DivGroupParam addValue(DivParam value){
		values.add(value);
		return this;
	}

	public List<DivParam> getValues() {
		return values;
	}

	public void setValues(List<DivParam> values) {
		this.values = values;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

}
