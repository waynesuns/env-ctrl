package com.waynesun.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;

import org.hibernate.criterion.Criterion;

/**
 * QC查询条件注解基类
 * @author wayne
 *
 */
public abstract class AbstractCriterionAdapter {
	/**
	 * 生成hibernate离线查询条件
	 * @param propertyName 属性名称
	 * @param propertyValue 属性值
	 * @param annotationss 注解
	 * @return
	 */
	public abstract Criterion generateCriteria(String propertyName, Object propertyValue, Annotation annotationss);
}