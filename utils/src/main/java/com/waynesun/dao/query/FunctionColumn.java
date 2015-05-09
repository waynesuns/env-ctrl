package com.waynesun.dao.query;

import com.waynesun.dao.query.condition.ColumnEntry;
import com.waynesun.dao.query.condition.ColumnFunctionEntry;

public class FunctionColumn extends Column implements IFunctionColumn {
	private QueryFunction function;
	
	public FunctionColumn() {
		super();
	}
	
	public FunctionColumn(String propertyName,String alias,QueryFunction function) {
		super(propertyName,alias);
		this.function=function;
	}
	public void setFunction(QueryFunction function) {
		this.function = function;
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
	public ColumnEntry getColumnEntry() {
		// TODO Auto-generated method stub
		return ColumnFunctionEntry.newInstance(getPropertyName(), getAlias(), getFunction());
	}
}
