package com.waynesun.dao.query;

import com.waynesun.dao.query.condition.ColumnEntry;

public abstract class Column implements IColumn {
	private String propertyName;
	private String alias;
	protected Column(){
		
	}
	protected Column(String propertyName,String alias){
		this.propertyName=propertyName;
		this.alias=alias;
	}
	@Override
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	@Override
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
}
