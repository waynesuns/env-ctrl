package com.waynesun.dao.query.condition.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模糊查询注解
 * @author wayne
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Like {
	/**全模糊*/
	int ANYWHERE = 1;
	/**尾部匹配*/
	int END = 2;
	/**精确匹配*/
	int EXACT = 3;
	/**头部匹配*/
	int START = 4;
	/**模糊查询类型,默认为全模糊*/
	int matchMode() default Like.ANYWHERE;
	
}
