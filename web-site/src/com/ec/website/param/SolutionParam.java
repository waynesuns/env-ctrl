package com.ec.website.param;

import java.util.ArrayList;
import java.util.List;

public class SolutionParam {
	private String headerPicName;
	private String activeSubItem;
	private String subItemTitle;
	private List<Menu> subItems = new ArrayList<Menu>();
	private String subItemHeaderImgInfo;
	private String subItemInfo;
	private List<SolutionSampleParam> samples = new ArrayList<SolutionSampleParam>();

	public void addSubItem(String name, String url){
		subItems.add(new Menu(name, url));
	}
	public void addSample(SolutionSampleParam sample){
		samples.add(sample);
	}

	public String getHeaderPicName() {
		return headerPicName;
	}

	public void setHeaderPicName(String headerPicName) {
		this.headerPicName = headerPicName;
	}

	public String getActiveSubItem() {
		return activeSubItem;
	}

	public void setActiveSubItem(String activeSubItem) {
		this.activeSubItem = activeSubItem;
	}

	public String getSubItemTitle() {
		return subItemTitle;
	}

	public void setSubItemTitle(String subItemTitle) {
		this.subItemTitle = subItemTitle;
	}


	public List<Menu> getSubItems() {
		return subItems;
	}
	public void setSubItems(List<Menu> subItems) {
		this.subItems = subItems;
	}
	public String getSubItemHeaderImgInfo() {
		return subItemHeaderImgInfo;
	}

	public void setSubItemHeaderImgInfo(String subItemHeaderImgInfo) {
		this.subItemHeaderImgInfo = subItemHeaderImgInfo;
	}

	public String getSubItemInfo() {
		return subItemInfo;
	}

	public void setSubItemInfo(String subItemInfo) {
		this.subItemInfo = subItemInfo;
	}

	public List<SolutionSampleParam> getSamples() {
		return samples;
	}

	public void setSamples(List<SolutionSampleParam> samples) {
		this.samples = samples;
	}
	
	
}
