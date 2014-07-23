package com.ec.website.param;

public class PartnerParam {
	private String name;
	private String logo;
	
	public PartnerParam(String name,String logo){
		this.name = name;
		this.logo = logo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
