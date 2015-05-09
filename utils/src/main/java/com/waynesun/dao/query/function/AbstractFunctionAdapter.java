package com.waynesun.dao.query.function;

import org.hibernate.criterion.Projection;

import com.waynesun.dao.query.condition.ColumnEntry;

public abstract class AbstractFunctionAdapter {

	public AbstractFunctionAdapter() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Projection generateProjection(ColumnEntry columnEntry, String fullPropertyName);
}
