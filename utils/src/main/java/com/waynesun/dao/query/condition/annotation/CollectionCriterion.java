package com.waynesun.dao.query.condition.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 集合条件注解（需与基本类型的条件注解联合使用）
 * 对应的属性应实现Collection接口，对于该属性会将list中所有的值按照定义的元素对应关系引入HQL中
 * 例：属性名为pojoState，列表中存在0，1两个值，元素对应关系为OR，基本类型的条件为eq，则实际的HQL相当于 and （pojoState=0 or pojoState =1）
 * @author wayne
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CollectionCriterion {
	int OR = 1;
	int AND = 2;
	/**元素对应关系（使用类变量的OR/AND）*/
	int elementRel();
}
