package com.ec.website.param.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ec.website.param.TableHeaderParam;
import com.ec.website.param.TableTdParam;

public class TableGroupParam extends AbstractGroupParam<TableGroupParam,List<TableTdParam>>{
	private List<TableHeaderParam> headers = new ArrayList<TableHeaderParam>();
	private List<List<TableTdParam>> values = new ArrayList<List<TableTdParam>>();
	private List<String> annons = new ArrayList<String>();
	
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
	public TableGroupParam addValue(List<TableTdParam> value) {
		values.add(value);
		return this;
	}
	
	public TableGroupParam addAnnon(String annon){
		this.annons.add(annon);
		return this;
	}
	public TableGroupParam addValue(String[] value){
		List<TableTdParam> params = new ArrayList<TableTdParam>();
		for(String v : value){
			params.add(new TableTdParam(v));
		}
		return this.addValue(params);
	}
	
	public TableGroupParam addValue(TableTdParam[] value){
		return this.addValue(Arrays.asList(value));
	}

	public List<TableHeaderParam> getHeaders() {
		return headers;
	}

	public void setHeaders(List<TableHeaderParam> headers) {
		this.headers = headers;
	}

	public List<List<TableTdParam>> getValues() {
		return values;
	}

	public void setValues(List<List<TableTdParam>> values) {
		this.values = values;
	}

	public List<String> getAnnons() {
		return annons;
	}

	public void setAnnons(List<String> annons) {
		this.annons = annons;
	}


}
