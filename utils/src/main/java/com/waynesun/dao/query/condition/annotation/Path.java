package com.waynesun.dao.query.condition.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 路径注解
 * 用于查询所有的子节点
 * 例如:父节点1,子节点1.1,1.2,三级节点1.1.1,1.1.2,1.2.1,查询参数为1.1,则将查询出节点编号为1.1.1及1.1.2的对象
 * @author wayne
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Path {
	
}
