package com.waynesun.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.waynesun.dao.query.IQueryPropertyBean;
import com.waynesun.dao.query.QueryPropertyChainBean;
import com.waynesun.dao.query.condition.ColumnEntry;
import com.waynesun.dao.query.condition.ComponentType;
import com.waynesun.dao.query.condition.ProjectionInterpreter;
import com.waynesun.dao.query.condition.QueryConditionEntry;
import com.waynesun.dao.query.condition.QueryConditionEntryAssemble;
import com.waynesun.dao.query.condition.QueryConditionEntryComponent;
import com.waynesun.dao.query.condition.annotation.CriterionAnnotationInterpreter;
import com.waynesun.dao.query.condition.annotation.JoinType;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.dao.query.order.Order;
import com.waynesun.dao.type.DaoType;

/**
 * @ClassName: CriteriaHandler
 * @Description: Hibernate在线查询处理器
 * @author zhengnan
 * @date 2014年3月31日 下午12:42:23
 *
 */
public class CriteriaHandler {

	/**
	 * @Title: processCriteria
	 * @Description: 生成Hibernate在线查询
	 * @param mainCriteria
	 * @param pl
	 * @param assemble
	 * @param columnEntrys
	 * @param groupEntrys
	 * @param orders
	 * @param propertyChainBean
	 * @return Criteria
	 * @throws
	 */
	public static Criteria processCriteria(Criteria mainCriteria, ProjectionList pl, QueryConditionEntryAssemble assemble, List<ColumnEntry> columnEntrys, List<ColumnEntry> groupEntrys, List<Order> orders, QueryPropertyChainBean propertyChainBean) {
		mainCriteria = CriteriaHandler.processCriteria(mainCriteria, assemble, orders, propertyChainBean);

		if (columnEntrys != null && !columnEntrys.isEmpty()) {
			if (pl == null) {
				pl = Projections.projectionList();
			}
			for (ColumnEntry columnEntry : columnEntrys) {
				pl.add(ProjectionInterpreter.generateProjection(columnEntry, propertyChainBean.getQueryPropertyBean(columnEntry.getPropertyName()).getFullPropertyName()));
			}
		}
		if (groupEntrys != null && !groupEntrys.isEmpty()) {
			if (pl == null) {
				pl = Projections.projectionList();
			}
			for (ColumnEntry columnEntry : groupEntrys) {
				pl.add(ProjectionInterpreter.generateProjection(columnEntry, propertyChainBean.getQueryPropertyBean(columnEntry.getPropertyName()).getFullPropertyName()));
			}
		}
		if (pl != null) {
			mainCriteria.setProjection(pl);
		}

		return mainCriteria;
	}

	/**
	 * @Title: processCriteria
	 * @Description: 生成Hibernate在线查询
	 * @param mainCriteria
	 * @param assemble
	 * @param orders
	 * @param propertyChainBean
	 * @return Criteria
	 * @throws
	 */
	public static Criteria processCriteria(Criteria mainCriteria, QueryConditionEntryAssemble assemble, List<Order> orders, QueryPropertyChainBean propertyChainBean) {
		addAlias(mainCriteria, propertyChainBean);
		addCriterions(mainCriteria, assemble, propertyChainBean);
		addOrders(mainCriteria, orders);
		return mainCriteria;
	}

	private static void addCriterions(Criteria mainCriteria, QueryConditionEntryAssemble assemble, QueryPropertyChainBean propertyChainBean) {
		Criterion criterion = getCriterion(assemble, propertyChainBean);			
		if (criterion != null) {
			mainCriteria.add(criterion);
		}
	}

	private static void addOrders(Criteria mainCriteria, List<Order> orders) {
		if (orders != null) {
			for (Order order : orders) {
				mainCriteria.addOrder(getHibernateOrder(order));
			}
		}
	}

	private static Criterion getCriterion(QueryConditionEntryAssemble assemble, QueryPropertyChainBean propertyChainBean) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion lhs = null;
		if (assemble.getEntries() != null) {
			for (QueryConditionEntry entry : assemble.getEntries()) {
				String propertyNameChain;
				if(entry.getPropertyDescriptor().getReadMethod().isAnnotationPresent(PropertyProxy.class)) {
					propertyNameChain = entry.getPropertyDescriptor().getReadMethod().getAnnotation(PropertyProxy.class).propertyChain();
				} else {
					propertyNameChain = entry.getPropertyDescriptor().getName();
				}

				IQueryPropertyBean propertyBean = propertyChainBean.getQueryPropertyBean(propertyNameChain);

				criterions.add(CriterionAnnotationInterpreter.generateCriteria(DaoType.HIBERNATE, propertyBean.getFullPropertyName(), entry.getPropertyValue(), entry.getPropertyDescriptor().getReadMethod()));
			}
			if (!criterions.isEmpty()) {
				lhs = Restrictions.and(criterions.toArray(new Criterion[criterions.size()]));		
			}
		}

		if (assemble.getComponents() != null && !assemble.getComponents().isEmpty()) {
			for (QueryConditionEntryComponent queryConditionEntryComponent : assemble.getComponents()) {
				Criterion rhs = getCriterion(queryConditionEntryComponent, propertyChainBean);
				lhs = getCriterion(lhs, rhs, queryConditionEntryComponent.getComponentType());
			}
		}

		return lhs;
	}

	private static void addAlias(Criteria mainCriteria, QueryPropertyChainBean propertyChainBean) {
		for (IQueryPropertyBean bean : propertyChainBean.getAllNeedRegisterQueryPropertyBeans()) {			
			mainCriteria.createCriteria(bean.getFullPropertyName(), bean.getAlias(), getHibernateJoinType(bean.getJoinType()));
		}
	}

	private static Criterion getCriterion(Criterion lhs, Criterion rhs, ComponentType componentType) {
		if (lhs == null) {
			return rhs;
		}
		if (rhs == null) {
			return lhs;
		}
		switch(componentType) {
			case OR:
				return Restrictions.or(lhs, rhs);
			case AND:
			default:
				return Restrictions.and(lhs, rhs);
		}
	}

	private static org.hibernate.criterion.Order getHibernateOrder(Order order) {
		switch(order.getOrderType()) {
			case DESC:
				return org.hibernate.criterion.Order.desc(order.getPropertyChain());
			case ASC:
			default:
				return org.hibernate.criterion.Order.asc(order.getPropertyChain());
		}
	}

	private static org.hibernate.sql.JoinType getHibernateJoinType(int joinType) {
		switch (joinType) {
			case JoinType.LEFT_JOIN:
				return org.hibernate.sql.JoinType.LEFT_OUTER_JOIN;
			case JoinType.RIGHT_JOIN:
				return org.hibernate.sql.JoinType.RIGHT_OUTER_JOIN;
			case JoinType.FULL_JOIN:
				return org.hibernate.sql.JoinType.FULL_JOIN;
			case JoinType.INNER_JOIN:
			default:
				return org.hibernate.sql.JoinType.INNER_JOIN;		
		}
	}
}