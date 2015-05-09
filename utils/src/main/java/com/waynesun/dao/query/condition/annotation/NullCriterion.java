package com.waynesun.dao.query.condition.annotation;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.spi.TypedValue;

/**
 * 空的离线查询
 * 相当于未加任何条件
 * @author wayne
 *
 */
public class NullCriterion implements Criterion{
	private static final long serialVersionUID = -1805206722414026101L;
	private static final NullCriterion instance = new NullCriterion();
	
	private NullCriterion(){
		
	}
	
	public static NullCriterion getInstance(){
		return NullCriterion.instance;
	}
	@Override
	public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery)
			throws HibernateException {
		// TODO Auto-generated method stub
		return "1=1";
	}

	@Override
	public TypedValue[] getTypedValues(Criteria criteria,
			CriteriaQuery criteriaQuery) throws HibernateException {
		// TODO Auto-generated method stub
		return new TypedValue[0];
	}

}
