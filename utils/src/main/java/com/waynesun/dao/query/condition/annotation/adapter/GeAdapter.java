package com.waynesun.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * 大于等于注解适配器
 * @author wayne
 *
 */
public class GeAdapter extends AbstractCriterionAdapter {

	@Override
	public Criterion generateCriteria(String propertyName,Object propertyValue, Annotation annotation) {
		return Restrictions.ge(propertyName, propertyValue);
	}
}