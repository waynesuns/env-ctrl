package com.waynesun.dao.query.condition;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询条件组件
 * @author weisun
 *
 */
public class QueryConditionComponent {

	/**组件类型*/
	private ComponentType componentType;
	/**查询条件*/
	private BaseQueryCondition condition;
	/**下一个查询条件*/
	private List<QueryConditionComponent> components = new ArrayList<QueryConditionComponent>();

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

	public ComponentType getComponentType() {
		return componentType;
	}

	public void setComponentType(ComponentType componentType) {
		this.componentType = componentType;
	}	
}