package com.fusioninfo.dao.query.condition;

import com.fusioninfo.dao.query.QueryFunction;

public class ColumnGroupPropertyEntry extends ColumnGroupEntry{

	private ColumnGroupPropertyEntry(String propertyName,String alias) {
		// TODO Auto-generated constructor stub
		super(propertyName,alias);
	}
	public static ColumnGroupPropertyEntry newInstance(String propertyName,String alias){
		return new ColumnGroupPropertyEntry(propertyName,alias);
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
}
