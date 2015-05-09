package com.waynesun.dao.query;

import java.util.List;

public abstract class SelectItemQuery<T extends IColumn> extends SimpleQuery {

	private List<T> queryColumns;

	@Override
	public  List<IColumn> getColumns() {
		// TODO Auto-generated method stub
		return (List<IColumn>)this.queryColumns;
	}

	public void setQueryColumns(List<T> queryColumns) {
		this.queryColumns = queryColumns;
	}
}