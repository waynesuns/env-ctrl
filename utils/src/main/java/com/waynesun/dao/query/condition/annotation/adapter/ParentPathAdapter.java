package com.waynesun.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.waynesun.dao.query.condition.annotation.NullCriterion;

public class ParentPathAdapter extends AbstractCriterionAdapter {

	@Override
	public Criterion generateCriteria(String propertyName, Object propertyValue, Annotation annotation) {
		String[] paths = propertyValue.toString().split("\\.");
		Criterion criterion = null;
		for(int i=0;i<paths.length;i++){
			if(criterion==null){
				criterion = Restrictions.eq(propertyName, StringUtils.join(ArrayUtils.subarray(paths, i, i),"."));
			}else{
				criterion = Restrictions.or(criterion, Restrictions.eq(propertyName, StringUtils.join(ArrayUtils.subarray(paths, i, i),".")));
			}
		}
		return criterion==null?NullCriterion.getInstance():criterion;
	}
}