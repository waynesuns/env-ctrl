package com.waynesun.dao.query.condition;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.waynesun.dao.query.QueryPropertyChainBean;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;

public class QueryConditionEntryAssemble {
	private List<QueryConditionEntry> entries;
	private List<QueryConditionEntryComponent> components = new ArrayList<QueryConditionEntryComponent>();

	public static QueryConditionEntryAssemble newInstance(QueryConditionAssenble assemble, QueryPropertyChainBean propertyChainBean) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		QueryConditionEntryAssemble condition = new QueryConditionEntryAssemble();
		condition.setQueryCondition(assemble.getCondition(), propertyChainBean);
		condition.addQueryConditionComponents(assemble.getComponents(), propertyChainBean);
		return condition;
	}

	private void addQueryConditionComponents(List<QueryConditionComponent> queryConditionComponents, QueryPropertyChainBean propertyChainBean) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if (queryConditionComponents != null) {
			for (QueryConditionComponent queryConditionComponent : queryConditionComponents) {
				QueryConditionEntryAssemble a = this.addQueryConditionComponent(queryConditionComponent, propertyChainBean);
				a.addQueryConditionComponents(queryConditionComponent.getComponents(), propertyChainBean);
			}
		}
	}

	protected QueryConditionEntryAssemble setQueryCondition(BaseQueryCondition condition, QueryPropertyChainBean propertyChainBean) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		this.entries = condition.generateEntries();
		if (this.entries != null) {
			for (QueryConditionEntry entry : this.entries) {
				String propertyName;
				if(entry.getPropertyDescriptor().getReadMethod().isAnnotationPresent(PropertyProxy.class)) {
					propertyName = entry.getPropertyDescriptor().getReadMethod().getAnnotation(PropertyProxy.class).propertyChain();
				} else {
					propertyName = entry.getPropertyDescriptor().getName();
				}
				propertyChainBean.addPropertyChainName(propertyName);
			}
		}
		return this;
	}

	private QueryConditionEntryAssemble addQueryConditionComponent(QueryConditionComponent component, QueryPropertyChainBean propertyChainBean) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		QueryConditionEntryComponent c = QueryConditionEntryComponent.newInstance(component.getComponentType(), component.getCondition(), propertyChainBean);
		this.components.add(c);
		return c;
	}

	public List<QueryConditionEntry> getEntries() {
		return entries;
	}

	public List<QueryConditionEntryComponent> getComponents() {
		return components;
	}
}