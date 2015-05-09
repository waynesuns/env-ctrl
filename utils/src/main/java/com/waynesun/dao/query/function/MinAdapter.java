package com.waynesun.dao.query.function;

import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.waynesun.dao.query.condition.ColumnEntry;

public class MinAdapter extends AbstractFunctionAdapter {

	public MinAdapter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Projection generateProjection(ColumnEntry columnEntry, String fullPropertyName) {
		// TODO Auto-generated method stub
		return Projections.max(fullPropertyName).as(columnEntry.getAlias());
	}

}
