package com.ec.website.param.group;

import java.util.List;

public abstract class AbstractGroupParam<T,V> {
	private String type = "div";
	private String title;
	private boolean isDoDelim;
	
	public AbstractGroupParam(String type,String title){
		this.type = type;
		this.title = title;
	}

	public abstract String getTemplatePath();
	
	public abstract List<V> getValues();
	
	public abstract T addValue(V value);
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDoDelim() {
		return isDoDelim;
	}

	public AbstractGroupParam<T, V> setDoDelim(boolean isDoDelim) {
		this.isDoDelim = isDoDelim;
		return this;
	}
	
	
	
}
