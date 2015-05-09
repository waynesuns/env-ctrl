package com.waynesun.dao.query.item;

import java.io.Serializable;

/**查询项基类*/
public class BaseQueryItem implements Serializable{
	private static final long serialVersionUID = 2332128690306348684L;
	
	/**排序属性名，子类属性以“.”隔开*/
	private String propertyChain;
	
	protected BaseQueryItem(String propertyChain){
		this.propertyChain = propertyChain;
	}

	public String getPropertyChain() {
		return propertyChain;
	}

	public void setPropertyChain(String propertyChain) {
		this.propertyChain = propertyChain;
	}	
}
