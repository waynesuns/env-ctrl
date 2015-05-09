package com.waynesun.dao.query.condition;

import org.hibernate.criterion.Criterion;

/**
 * hql的查询条件
 * 
 * @see ConditionExpression
 * @see org.hibernate.criterion.Criterion
 * @author  
 * 
 */
public interface Condition {

	/**
	 * @return 用于在Hibernate3中查询Criteria的Criterion
	 */
	public Criterion getCriterion();
}
