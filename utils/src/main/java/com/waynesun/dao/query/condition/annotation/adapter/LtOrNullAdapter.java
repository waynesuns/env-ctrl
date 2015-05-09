package com.waynesun.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * 小于或为空注解
 * @author wayne
 *
 */
public class LtOrNullAdapter extends AbstractCriterionAdapter {

	@Override
	public Criterion generateCriteria(String propertyName, Object propertyValue, Annotation annotation) {
		return Restrictions.or(Restrictions.le(propertyName, propertyValue), Restrictions.isNull(propertyName));
	}
}