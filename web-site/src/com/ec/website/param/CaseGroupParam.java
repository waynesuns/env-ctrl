package com.ec.website.param;

import java.util.ArrayList;
import java.util.List;

public class CaseGroupParam {
	private String groupName;
	private List<CaseItemParam> items = new ArrayList<CaseItemParam>();
	public CaseGroupParam(String groupName){
		this.groupName = groupName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<CaseItemParam> getItems() {
		return items;
	}
	public void setItems(List<CaseItemParam> items) {
		this.items = items;
	}
	
	public void addItem(CaseItemParam item){
		items.add(item);
	}
	
}
