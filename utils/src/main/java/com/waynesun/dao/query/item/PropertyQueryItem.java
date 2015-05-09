package com.waynesun.dao.query.item;

/**属性名查询项*/
public class PropertyQueryItem extends BaseQueryItem{
	private static final long serialVersionUID = -938149837093269529L;
	
	private PropertyQueryItem(String propertyChain) {
		super(propertyChain);
	}

	public static PropertyQueryItem getInstance(String propertyChain){
		return new PropertyQueryItem(propertyChain);
	}

}
