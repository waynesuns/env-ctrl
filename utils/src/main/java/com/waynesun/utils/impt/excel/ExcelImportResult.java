package com.waynesun.utils.impt.excel;

import java.util.ArrayList;
import java.util.List;

import com.waynesun.utils.impt.ImportSuccessParam;

public class ExcelImportResult<T> {
	private List<T> datas;
	private List<String> errors;
	private List<ImportSuccessParam> successInfos=new ArrayList<ImportSuccessParam>();
	
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public List<ImportSuccessParam> getSuccessInfos() {
		return successInfos;
	}
	public void setSuccessInfos(List<ImportSuccessParam> successInfos) {
		this.successInfos = successInfos;
	}
	
}
