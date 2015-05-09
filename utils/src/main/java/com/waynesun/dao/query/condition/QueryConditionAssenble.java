package com.waynesun.dao.query.condition;

import java.util.List;

public class QueryConditionAssenble implements QueryCondition {
	private static final long serialVersionUID = 1L;

	/** 查询条件 */
	private BaseQueryCondition condition;
	/** 下一个查询条件 */
	private List<QueryConditionComponent> components;

	public BaseQueryCondition getCondition() {
		return condition;
	}

	public void setCondition(BaseQueryCondition condition) {
		this.condition = condition;
	}

	public List<QueryConditionComponent> getComponents() {
		return components;
	}

	public void setComponents(List<QueryConditionComponent> components) {
		this.components = components;
	}
}