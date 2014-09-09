package com.ec.website.param;

public class TableTdParam {
	private String text;
	private String cssClassName;
	private int rowSpan = 1;
	public TableTdParam(String text){
		this.text = text;
	}
	public TableTdParam(String text,int rowSpan){
		this.text = text;
		this.rowSpan = rowSpan;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCssClassName() {
		return cssClassName;
	}
	public void setCssClassName(String cssClassName) {
		this.cssClassName = cssClassName;
	}
	public int getRowSpan() {
		return rowSpan;
	}
	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}
	
	
}
