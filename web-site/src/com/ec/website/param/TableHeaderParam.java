package com.ec.website.param;

public class TableHeaderParam {
	private String name;
	private String width;
	private int colspan = 1;
	
	public TableHeaderParam(String name,String width){
		this.name = name;
		this.width = width;
	}
	public TableHeaderParam(String name,int colspan){
		this.name = name;
		this.colspan = colspan;
	}
	public TableHeaderParam(String name,String width,int colspan){
		this.name = name;
		this.width = width;
		this.colspan = colspan;
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
	public int getColspan() {
		return colspan;
	}
	public void setColspan(int colspan) {
		this.colspan = colspan;
	}
	
	
}
