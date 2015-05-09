package com.waynesun.dao.query.group;

import java.io.Serializable;
import java.util.List;

import com.waynesun.dao.query.condition.QueryCondition;

/**
 * 
 * 分组条件
 * @author weisun
 *
 */
public class Group implements Serializable{
	private static final long serialVersionUID = 7246964629971159328L;
	/**分组对象*/
	private List<String> groupByers;
	/**分组条件*/
	private List<QueryCondition> havings;
	
	public List<String> getGroupByers() {
		return groupByers;
	}
	public void setGroupByers(List<String> groupByers) {
		this.groupByers = groupByers;
	}
	public List<QueryCondition> getHavings() {
		return havings;
	}
	public void setHavings(List<QueryCondition> havings) {
		this.havings = havings;
	}
}
