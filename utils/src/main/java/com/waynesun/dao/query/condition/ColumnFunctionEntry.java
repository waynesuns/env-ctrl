package com.waynesun.dao.query.condition;

import com.waynesun.dao.query.QueryFunction;

public class ColumnFunctionEntry extends ColumnEntry {
	private QueryFunction function;
	private ColumnFunctionEntry(){
		
	}
	private ColumnFunctionEntry(String propertyName,String alias,QueryFunction function){
		super(propertyName,alias);
		this.function=function;
	}
	public static ColumnFunctionEntry newInstance(String propertyName,String alias,QueryFunction function){
		return new ColumnFunctionEntry(propertyName,alias,function);
	}
	@Override
	public boolean isFunction() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public QueryFunction getFunction() {
		// TODO Auto-generated method stub
		return this.function;
	}

	@Override
	public boolean isGroup() {
		// TODO Auto-generated method stub
		return false;
	}

}
