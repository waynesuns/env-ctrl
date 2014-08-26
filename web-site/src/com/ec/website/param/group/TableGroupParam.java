package com.ec.website.param.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ec.website.param.TableHeaderParam;

public class TableGroupParam extends AbstractGroupParam<TableGroupParam,List<String>>{
	private List<TableHeaderParam> headers = new ArrayList<TableHeaderParam>();
	private List<List<String>> values = new ArrayList<List<String>>();
	
	public TableGroupParam(String title) {
		super("table", title);
	}

	@Override
	public String getTemplatePath() {
		return "table.jsp";
	}

	public TableGroupParam addHeader(TableHeaderParam header){
		this.headers.add(header);
		return this;
	}
	@Override
	public TableGroupParam addValue(List<String> value) {
		values.add(value);
		return this;
	}
	
	public TableGroupParam addValue(String[] value){
		return this.addValue(Arrays.asList(value));
	}

	public List<TableHeaderParam> getHeaders() {
		return headers;
	}

	public void setHeaders(List<TableHeaderParam> headers) {
		this.headers = headers;
	}

	public List<List<String>> getValues() {
		return values;
	}

	public void setValues(List<List<String>> values) {
		this.values = values;
	}


}
