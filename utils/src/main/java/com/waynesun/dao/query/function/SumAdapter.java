package com.waynesun.dao.query.function;

import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.waynesun.dao.query.condition.ColumnEntry;

public class SumAdapter extends AbstractFunctionAdapter {

	public SumAdapter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Projection generateProjection(ColumnEntry columnEntry, String fullPropertyName) {
		// TODO Auto-generated method stub
		return Projections.sum(fullPropertyName).as(columnEntry.getAlias());
	}

}
