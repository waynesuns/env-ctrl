package com.waynesun.dao.query;

import java.io.Serializable;
import java.util.List;

import com.waynesun.dao.query.condition.QueryCondition;
import com.waynesun.dao.query.order.Order;

/***
 * 查询基类
 * @author weisun
 *
 */
public abstract class BaseQuery implements Serializable{
	private static final long serialVersionUID = -4763302850264609027L;
	/**查询条件列表*/
	private QueryCondition queryCondtion;
	/**排序列表*/
	private List<Order> orders;
	
	public QueryCondition getQueryCondtion() {
		return queryCondtion;
	}
	public void setQueryCondtion(QueryCondition queryCondtion) {
		this.queryCondtion = queryCondtion;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public abstract  List<IColumn> getColumns();
	public abstract  List<IColumn> getGroups();
}
