package com.ec.website.param;

import java.util.ArrayList;
import java.util.List;

public class PartnerGroupParam {
	private String name;
	private List<PartnerParam> partners = new ArrayList<PartnerParam>();
	public PartnerGroupParam(String name){
		this.name = name;
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
	
}
