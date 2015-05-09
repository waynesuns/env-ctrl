package com.fusioninfo.dao.query.condition;

import com.fusioninfo.dao.query.IColumn;
import com.fusioninfo.dao.query.QueryFunction;

public abstract class ColumnEntry {
	private String propertyName;
	private String alias;
	
	protected ColumnEntry() {
		super();
	}
	protected ColumnEntry(String propertyName, String alias) {
		super();
		this.propertyName = propertyName;
		this.alias = alias;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public abstract boolean isFunction();
	public abstract QueryFunction getFunction();
	public abstract boolean isGroup();
	public static ColumnEntry newInstance(IColumn column){
		if(column.isFunction()){
			return ColumnFunctionEntry.newInstance(column.getPropertyName(), column.getAlias(), column.getFunction());
		}else {
			return ColumnPropertyEntry.newInstance(column.getPropertyName(), column.getAlias());
		}
	}
	
}
