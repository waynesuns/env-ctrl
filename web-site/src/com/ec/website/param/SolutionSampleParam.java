package com.ec.website.param;

public class SolutionSampleParam {
	private String title;
	private String info;
	private String picName;
	
	public SolutionSampleParam(String title,String picName,String info){
		this.title = title;
		this.info = info;
		this.picName = picName;
	}
	public SolutionSampleParam(String title,String info){
		this.title = title;
		this.info = info;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	
	
}
