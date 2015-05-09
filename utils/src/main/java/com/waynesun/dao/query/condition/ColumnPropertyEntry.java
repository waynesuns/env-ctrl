package com.waynesun.dao.query.condition;

import com.waynesun.dao.query.IColumn;
import com.waynesun.dao.query.QueryFunction;

public class ColumnPropertyEntry extends ColumnEntry {
	private ColumnPropertyEntry(){}
	private ColumnPropertyEntry(String propertyName,String alias){
		super(propertyName,alias);
	}
	public static ColumnPropertyEntry newInstance(String propertyName,String alias){
		return new ColumnPropertyEntry(propertyName,alias);
	}
	
	@Override
	public boolean isFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QueryFunction getFunction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isGroup() {
		// TODO Auto-generated method stub
		return false;
	}

}
