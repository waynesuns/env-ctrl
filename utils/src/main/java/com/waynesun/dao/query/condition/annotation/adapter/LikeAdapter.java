package com.waynesun.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.waynesun.dao.query.condition.annotation.Like;

/**
 * 模糊查询注解适配器
 * @author wayne
 *
 */
public class LikeAdapter extends AbstractCriterionAdapter {

	@Override
	public Criterion generateCriteria(String propertyName, Object propertyValue, Annotation annotation) {
		Like like = (Like)annotation;
		MatchMode matchMode = null;
		switch (like.matchMode()) {
		case Like.ANYWHERE:
			matchMode = MatchMode.ANYWHERE;
			break;
		case Like.END:
			matchMode = MatchMode.END;
			break;
		case Like.EXACT:
			matchMode = MatchMode.EXACT;
			break;
		case Like.START:
			matchMode = MatchMode.START;
			break;
		default:
			matchMode = MatchMode.ANYWHERE;
		}
//		System.out.println("propertyValue.toString():"+propertyValue.toString());
//		System.out.println("propertyValue.toString():"+Restrictions.like(propertyName, propertyValue.toString(),matchMode));
		return Restrictions.like(propertyName, propertyValue.toString(),matchMode);
	}
}