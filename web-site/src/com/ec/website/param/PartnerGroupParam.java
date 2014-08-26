package com.ec.website.param;

import java.util.ArrayList;
import java.util.List;

public class PartnerGroupParam {
	private String name;
	private String type = "div";
	private List<PartnerParam> partners = new ArrayList<PartnerParam>();
	public PartnerGroupParam(String name){
		this.name = name;
	}
	public PartnerGroupParam(String name,String type){
		this.name = name;
		this.type = type;
	}
	public void addPartnerParam(PartnerParam partner){
		partners.add(partner);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PartnerParam> getPartners() {
		return partners;
	}
	public void setPartners(List<PartnerParam> partners) {
		this.partners = partners;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
