package com.waynesun.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * 全匹配注解适配器
 * @author wayne
 *
 */
public class EqAdapter extends AbstractCriterionAdapter {

	@Override
	public Criterion generateCriteria(String propertyName, Object propertyValue, Annotation annotation) {
		return Restrictions.eq(propertyName, propertyValue);
	}
}