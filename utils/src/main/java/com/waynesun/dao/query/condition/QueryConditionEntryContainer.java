package com.waynesun.dao.query.condition;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.waynesun.dao.query.BaseQuery;
import com.waynesun.dao.query.IColumn;
import com.waynesun.dao.query.QueryPropertyChainBean;
import com.waynesun.dao.query.order.Order;

public class QueryConditionEntryContainer {
	private QueryConditionEntryAssemble assemble;
	private List<Order> orders;
	private List<ColumnEntry> columnEntrys;
	private List<ColumnEntry> groupEntrys;
	private QueryPropertyChainBean propertyChainBean = QueryPropertyChainBean.newInstance();
	

	public static QueryConditionEntryContainer newInstance(BaseQuery query) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		QueryConditionEntryContainer container = new QueryConditionEntryContainer();
		container.setAssemble(QueryConditionEntryAssemble.newInstance((QueryConditionAssenble) query.getQueryCondtion(), container.getPropertyChainBean()));
		container.setOrders(query.getOrders());
		if(query.getColumns()!=null&&query.getColumns().size()>0){
			List<ColumnEntry> columns=new ArrayList<ColumnEntry>();
			for (IColumn column : query.getColumns()) {
				columns.add(ColumnEntry.newInstance(column));
			}
			container.setColumnEntrys(columns);
		}
		if(query.getGroups()!=null&&query.getGroups().size()>0){
			List<ColumnEntry> groups=new ArrayList<ColumnEntry>();
			for (IColumn column : query.getGroups()) {
				groups.add(ColumnGroupEntry.newInstance(column));
			}
			container.setGroupEntrys(groups);
		}
		
		return container;
	}

	public QueryConditionEntryAssemble getAssemble() {
		return assemble;
	}

	private void setAssemble(QueryConditionEntryAssemble assemble) {
		this.assemble = assemble;
	}

	public List<Order> getOrders() {
		return orders;
	}

	private void setOrders(List<Order> orders) {
		this.orders = orders;
		if (this.orders != null) {
			for (Order order : orders) {
				this.getPropertyChainBean().addPropertyChainName(order.getPropertyChain());
			}
		}
	}

	public List<ColumnEntry> getColumnEntrys() {
		return columnEntrys;
	}

	private void setColumnEntrys(List<ColumnEntry> columnEntrys) {
		this.columnEntrys = columnEntrys;
		if (this.columnEntrys != null) {
			for (ColumnEntry entry : this.columnEntrys) {
				this.getPropertyChainBean().addPropertyChainName(entry.getPropertyName());
			}
		}
	}

	public List<ColumnEntry> getGroupEntrys() {
		return groupEntrys;
	}

	private void setGroupEntrys(List<ColumnEntry> groupEntrys) {
		this.groupEntrys = groupEntrys;
		if (this.groupEntrys != null) {
			for (ColumnEntry entry : this.groupEntrys) {
				this.getPropertyChainBean().addPropertyChainName(entry.getPropertyName());
			}
		}
	}

	public QueryPropertyChainBean getPropertyChainBean() {
		return propertyChainBean;
	}
}