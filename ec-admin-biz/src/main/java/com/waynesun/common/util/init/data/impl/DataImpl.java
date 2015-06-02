package com.waynesun.common.util.init.data.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.waynesun.common.biz.area.AbstractArea;
import com.waynesun.common.biz.config.SystemConfig;
import com.waynesun.common.biz.dictionary.DictionaryCategory;
import com.waynesun.common.biz.dictionary.DictionaryItem;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.util.init.data.Data;
import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.hibernate.HibernateDaoImpl;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.ec.biz.order.OrderNoCacheBean;
import com.waynesun.ec.biz.order.SaleOrder;

public class DataImpl implements Data {

	@Override
	public List<AbstractDealer> findAllDealers() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(AbstractDealer.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<AbstractArea> findAllAreas() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(AbstractArea.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<SystemConfig> findAllSystemConfigs() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(SystemConfig.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<Resource> findAllResources() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(Resource.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<Role> findAllRoles() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(Role.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<DictionaryItem> findAllDictionaryItems() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(DictionaryItem.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<DictionaryCategory> findAllDictionaryCategories() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(DictionaryCategory.class, null, new SimpleQuery(), false).getResults();
	}
	
	public OrderNoCacheBean findOrderNoCacheBean() {
		DetachedCriteria ceiteria = DetachedCriteria.forClass(SaleOrder.class);
		Projection projection = Projections.projectionList().add(Projections.max("orderNo"));
		ceiteria.setProjection(projection);
		List<Object> values = ((HibernateDaoImpl)DaoFactory.getInstance().getQueryDao()).getHibernateTemplate().findByCriteria(ceiteria);
		OrderNoCacheBean bean = new OrderNoCacheBean();
		if(values!=null && !values.isEmpty() && values.get(0)!=null){
			bean = OrderNoCacheBean.valueOf(values.get(0).toString());
		}
		return bean;
	}
}
