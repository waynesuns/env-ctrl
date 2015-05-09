package com.waynesun.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;
import java.util.Collection;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.waynesun.dao.query.condition.annotation.CollectionCriterion;

/**
 * 集合条件注解的适配器
 * @author wayne
 *
 */
public class CollectionCriterionAdapter extends AbstractCriterionAdapter {
	/**基本类型条件注解适配器*/
	public AbstractCriterionAdapter elementAdapter;
	/**集合注解*/
	public CollectionCriterion collectionCriterion;
	
	public CollectionCriterionAdapter(AbstractCriterionAdapter elementAdapter,CollectionCriterion collectionCriterion){
		this.elementAdapter = elementAdapter;
		this.collectionCriterion = collectionCriterion;
	}
	@Override
	public Criterion generateCriteria(String propertyName, Object propertyValue, Annotation annotation) {
		Criterion criterion = null;
		@SuppressWarnings("unchecked")
		Collection<Object> collection = (Collection<Object>)propertyValue; 
		for(Object obj : collection){
			if(criterion==null){
				//若为第一个条件元素则直接生成
				criterion = elementAdapter.generateCriteria(propertyName, obj, annotation);
			}else{
				//若为第二个以后的条件元素则根据元素对应关系增加AND/OR的条件
				switch (collectionCriterion.elementRel()) {
				case CollectionCriterion.AND:
					criterion = Restrictions.and(criterion, elementAdapter.generateCriteria(propertyName, obj, annotation));
					break;

				default:
					criterion = Restrictions.or(criterion, elementAdapter.generateCriteria(propertyName, obj, annotation));
					break;
				}
				
			}
		}
		return criterion;
	}

}
