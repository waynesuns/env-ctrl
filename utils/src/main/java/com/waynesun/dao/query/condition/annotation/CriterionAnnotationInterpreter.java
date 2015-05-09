package com.waynesun.dao.query.condition.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.waynesun.dao.query.condition.annotation.adapter.AbstractCriterionAdapter;
import com.waynesun.dao.query.condition.annotation.adapter.CollectionCriterionAdapter;
import com.waynesun.dao.query.condition.annotation.adapter.CriterionAdapterFactory;
import com.waynesun.dao.type.DaoType;

/**
 * 查询注解处理器
 * @author wayne
 *
 */
public class CriterionAnnotationInterpreter {

	/**
	 * @Title: generateCriteria
	 * @Description: 生成hibernate离线查询条件
	 * @param daoType
	 * @param condition
	 * @param propertyName
	 * @param propertyValue
	 * @param readMethod
	 * @return Criterion
	 * @throws
	 */
	public static Criterion generateCriteria(DaoType daoType, String propertyName, Object propertyValue, Method readMethod){
		//是否含有集合条件注解
		boolean isCollectionCriterion = readMethod.isAnnotationPresent(CollectionCriterion.class);
		//是否加了非注解
		boolean isNot = readMethod.isAnnotationPresent(IsNot.class);
		AbstractCriterionAdapter adapter = null;
		Annotation[] annotations = readMethod.getAnnotations();
		for(Annotation annotation : annotations){
			//获取注解适配器
			adapter = CriterionAdapterFactory.getAdapter(daoType, annotation.annotationType());
			if(adapter != null){
				if(isCollectionCriterion){
					//若含有集合条件注解，则生成集合条件注解适配器
					adapter = new CollectionCriterionAdapter(adapter, readMethod.getAnnotation(CollectionCriterion.class));
				}
				//生成hibernate离线查询条件
				Criterion criterion = adapter.generateCriteria(propertyName, propertyValue, annotation);
				//根据是否加了非注解返回对应的理想查询条件
				return isNot?Restrictions.not(criterion):criterion;
			}
				
		}
		//若未加任何注解则使用like进行查询
		Criterion criterion = Restrictions.like(propertyName, propertyValue.toString(), MatchMode.ANYWHERE);
		return isNot?Restrictions.not(criterion):criterion;
	}
}