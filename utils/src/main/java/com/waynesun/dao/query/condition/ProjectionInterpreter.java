package com.waynesun.dao.query.condition;

import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.waynesun.dao.query.function.FunctionAdapterFactory;

public class ProjectionInterpreter {

	public ProjectionInterpreter() {
		// TODO Auto-generated constructor stub
	}

	public static Projection generateProjection(ColumnEntry columnEntry, String fullPropertyName) {
		if(columnEntry.isGroup()){
			return Projections.groupProperty(fullPropertyName).as(columnEntry.getAlias());
		} else {
			if(!columnEntry.isFunction()){
				return Projections.property(fullPropertyName).as(columnEntry.getAlias());
			}else{
				return FunctionAdapterFactory.getAdapter(columnEntry.getFunction()).generateProjection(columnEntry, fullPropertyName);
			}
		}
	}
}