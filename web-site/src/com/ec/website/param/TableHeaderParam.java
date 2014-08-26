package com.ec.website.param;

public class TableHeaderParam {
	private String name;
	private String width;
	
	public TableHeaderParam(String name,String width){
		this.name = name;
		this.width = width;
	}
	public TableHeaderParam(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	
	
}
