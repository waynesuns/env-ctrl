package com.fusioninfo.dao.query;

import com.fusioninfo.dao.query.condition.ColumnEntry;

public interface IColumn {
	public String getPropertyName();
	public String getAlias();
	public boolean isFunction();
	public QueryFunction getFunction();
	public ColumnEntry getColumnEntry();
}
