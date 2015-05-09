package com.waynesun.dao.query.condition.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 联合查询类型
 * @author wayne
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface JoinType {
	/**内连接*/
	int INNER_JOIN = 0;
	/**左连接*/
	int LEFT_JOIN = 1;
	/**右连接*/
	int RIGHT_JOIN = 2;
	/**全连接*/
	int FULL_JOIN = 4;
	/**连接类型,默认为内连接*/
	int joinType() default 0;
}