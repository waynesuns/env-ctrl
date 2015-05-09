package com.waynesun.dao.query.condition;

import java.lang.reflect.InvocationTargetException;

import com.waynesun.dao.query.QueryPropertyChainBean;

public class QueryConditionEntryComponent extends QueryConditionEntryAssemble {
	private ComponentType componentType;

	private QueryConditionEntryComponent(){
		
	}
	
	public static QueryConditionEntryComponent newInstance(ComponentType componentType, BaseQueryCondition condition, QueryPropertyChainBean propertyChainBean) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		QueryConditionEntryComponent component = new QueryConditionEntryComponent();
		component.setComponentType(componentType);
		component.setQueryCondition(condition, propertyChainBean);
		return component;
	}

	public ComponentType getComponentType() {
		return componentType;
	}

	private void setComponentType(ComponentType componentType) {
		this.componentType = componentType;
	}
}
