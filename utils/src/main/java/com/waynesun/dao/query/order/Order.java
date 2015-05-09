package com.waynesun.dao.query.order;

import java.io.Serializable;

/***
 * 
 * 排序规则
 * @author weisun
 *
 */
public class Order implements Serializable {
	private static final long serialVersionUID = 6270630372359944627L;
	/**排序属性名，子类属性以“.”隔开*/
	private String propertyChain;
	/**排序类型*/
	private OrderType orderType;
	
	private Order(String propertyChain,OrderType orderType){
		this.propertyChain = propertyChain;
		this.orderType = orderType;
	}
	/**
	 * 获取新实例
	 * @param propertyChain
	 * @param orderType
	 * @return
	 */
	private static Order newInstance(String propertyChain,OrderType orderType){
		return new Order(propertyChain,orderType);
	}
	/**
	 * 正序
	 * @param propertyChain
	 * @return
	 */
	public static Order asc(String propertyChain){
		return Order.newInstance(propertyChain, OrderType.ASC);
	}
	/**
	 * 倒序
	 * @param propertyChain
	 * @return
	 */
	public static Order desc(String propertyChain){
		return Order.newInstance(propertyChain, OrderType.DESC);
	}
	
	public String getPropertyChain() {
		return propertyChain;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	
	
}
