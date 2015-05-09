package com.fusioninfo.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * 大于注解适配器
 * @author wayne
 *
 */
public class GtAdapter extends AbstractCriterionAdapter {

	@Override
	public Criterion generateCriteria(String propertyName, Object propertyValue, Annotation annotation) {
		return Restrictions.gt(propertyName, propertyValue);
	}
}