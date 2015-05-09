package com.waynesun.dao.query.condition.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性代理注解
 * 用以解决qc属性名与待查询属性名不同的问题
 * 例如:qc中的"propertyA"属性需对实体类中的"propertyB"属性进行查询,则将该注解的propertyChain设置为"propertyB"即可(支持属性链,以"."分割)
 * @author wayne
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PropertyProxy {
	/**实际需查询的属性链*/
	String propertyChain();
}
