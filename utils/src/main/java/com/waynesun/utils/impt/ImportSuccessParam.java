package com.waynesun.utils.impt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImportSuccessParam {
	public static final int ADD=1;
	public static final int UPDATE=2;
	private int rowNum;
	private int type;
	private List<String> params=new ArrayList<String>();
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public List<String> getParams() {
		return params;
	}
	public void setParams(List<String> params) {
		this.params = params;
	}
	public ImportSuccessParam(int rowNum,int type, String... params) {
		super();
		this.rowNum = rowNum;
		this.type=type;
		this.params = Arrays.asList(params);
	}
	public ImportSuccessParam() {
		super();
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
