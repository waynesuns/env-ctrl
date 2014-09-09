package com.ec.website.param;

public class ImageParam {

	private String url;
	private String annon;
	
	public ImageParam(String url) {
		this.url = url;
	}
	public ImageParam(String url,String annon) {
		this(url);
		this.annon = annon;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAnnon() {
		return annon;
	}
	public void setAnnon(String annon) {
		this.annon = annon;
	}
	
	
}
