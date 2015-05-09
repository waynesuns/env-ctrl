package com.waynesun.dao.query.condition;

import java.beans.PropertyDescriptor;

public class QueryConditionEntry {
	private PropertyDescriptor propertyDescriptor;
	private Object propertyValue;
	
	private QueryConditionEntry(PropertyDescriptor propertyDescriptor,Object propertyValue){
		this.propertyDescriptor = propertyDescriptor;
		this.propertyValue = propertyValue;
	}
	public static QueryConditionEntry newInstance(PropertyDescriptor propertyDescriptor,Object propertyValue){
		return new QueryConditionEntry(propertyDescriptor,propertyValue);
	}
	public PropertyDescriptor getPropertyDescriptor() {
		return propertyDescriptor;
	}
	public void setPropertyDescriptor(PropertyDescriptor propertyDescriptor) {
		this.propertyDescriptor = propertyDescriptor;
	}
	public Object getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(Object propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	
}
