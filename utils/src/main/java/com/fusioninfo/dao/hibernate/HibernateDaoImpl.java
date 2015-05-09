package com.fusioninfo.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.fusioninfo.dao.MaintainDao;
import com.fusioninfo.dao.QueryDao;
import com.fusioninfo.dao.query.SelectItemQuery;
import com.fusioninfo.dao.query.SimpleQuery;
import com.fusioninfo.dao.query.condition.BaseQueryCondition;
import com.fusioninfo.dao.query.condition.QueryConditionAssenble;
import com.fusioninfo.dao.query.condition.QueryConditionEntryContainer;
import com.fusioninfo.dao.query.pages.QueryPages;
import com.fusioninfo.dao.query.result.QueryResult;
import com.fusioninfo.pojo.BasePojo;
import com.fusioninfo.pojo.BizObject;
import com.fusioninfo.pojo.Pages;
import com.fusioninfo.pojo.PojoState;
import com.fusioninfo.pojo.User;
import com.fusioninfo.pojo.VirtualDelete;
import com.fusioninfo.utils.UserUtils;

public class HibernateDaoImpl extends HibernateDaoSupport implements QueryDao,MaintainDao {

	@Override
	public void save(BasePojo pojo) {
		if (pojo instanceof BizObject)
		{
			User user = UserUtils.getUser();
			BizObject bo = (BizObject) pojo;
			if (bo.getId() == null){
				bo.setCreateTime(new Date());
			}
			if (bo.getId() == null && bo.getCreateUser() == null){
				bo.setCreateUser(user);
			}
			bo.setUpdateTime(new Date());
			bo.setUpdateUser(user);
		}

		getHibernateTemplate().saveOrUpdate(pojo);
	}

	@Override
	public void remove(BasePojo pojo) {
		if(pojo instanceof VirtualDelete)
		{
			((VirtualDelete)pojo).setState(PojoState.DELETED);
			this.save(pojo);
		}
		else
			getHibernateTemplate().delete(pojo);
	}

	@Override
	public int bulkUpdate(String hql, Object... values) {
		return getHibernateTemplate().bulkUpdate(hql, values);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<? extends BasePojo> clazz, String id, boolean cacheable) {
		Criteria query = this.createCriteria(clazz, cacheable);
		List<T> list = query.add(Restrictions.idEq(id)).list();
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T uniqueResult(Class<? extends BasePojo> clazz, SimpleQuery query, boolean cacheable) {
		List<T> list = (List<T>) this.list(clazz, null, query, cacheable).getResults();
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BasePojo, Q extends T> QueryResult<T> list(final Class<Q> clazz, final QueryPages pages, final SimpleQuery query, final boolean cacheable) {
		if (query.getQueryCondtion() == null) {
			query.setQueryCondtion(new QueryConditionAssenble());
		}

		if(query.getQueryCondtion() instanceof QueryConditionAssenble) {
			QueryConditionAssenble qca = (QueryConditionAssenble) query.getQueryCondtion();
			if (qca.getCondition() == null) {
				qca.setCondition(new BaseQueryCondition() {});
			}

			Object result = getHibernateTemplate().execute(new HibernateCallback<Object>() {
						public Object doInHibernate(Session session) throws HibernateException {
							QueryConditionEntryContainer container = null;
							try {
								container = QueryConditionEntryContainer.newInstance(query);
							} catch (Exception e) {
								throw new HibernateException(e);
							}

							if (pages != null) {
								Criteria countCriteria = session.createCriteria(clazz);
								countCriteria.setCacheable(cacheable);
								countCriteria.setProjection(Projections.projectionList().add(Projections.rowCount()));
								countCriteria = CriteriaHandler.processCriteria(countCriteria, container.getAssemble(), null, container.getPropertyChainBean());
								Object o = countCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).uniqueResult();
								Long count = o == null ? 0 : (Long) o;
								((Pages) pages).setTotalRow(count.intValue());
							}

							Criteria criteria = session.createCriteria(clazz);
							criteria.setCacheable(cacheable);
							criteria = CriteriaHandler.processCriteria(criteria, container.getAssemble(), container.getOrders(), container.getPropertyChainBean());
							if (pages != null) {
								criteria.setFirstResult(pages.getFirstRow() - 1);
								criteria.setMaxResults(pages.getPageSize());
							}
							List<T> result = criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

							return new QueryResult<T>(result, (Pages) pages);
						}
					});

			return (QueryResult<T>) result;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> QueryResult<T> list(final Class<? extends BasePojo> clazz, final Class<T> returnClazz, final SelectItemQuery<?> query, final boolean cacheable) {
		if (query.getQueryCondtion() == null) {
			query.setQueryCondtion(new QueryConditionAssenble());
		}

		if(query.getQueryCondtion() instanceof QueryConditionAssenble) {
			QueryConditionAssenble qca = (QueryConditionAssenble) query.getQueryCondtion();
			if (qca.getCondition() == null) {
				qca.setCondition(new BaseQueryCondition() {});
			}

			Object result = getHibernateTemplate().execute(new HibernateCallback<Object>() {
						public Object doInHibernate(Session session) throws HibernateException {
							QueryConditionEntryContainer container = null;
							try {
								container = QueryConditionEntryContainer.newInstance(query);
							} catch (Exception e) {
								throw new HibernateException(e);
							}

//							if (pages != null) {
//								Criteria countCriteria = session.createCriteria(clazz);
//								countCriteria.setCacheable(cacheable);
//								ProjectionList pl = Projections.projectionList().add(Projections.rowCount());
//								countCriteria = CriteriaHandler.processCriteria(countCriteria, pl, container.getAssemble(), container.getColumnEntrys(), container.getGroupEntrys(), null, container.getPropertyChainBean());
//								Object o = countCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).uniqueResult();
//								Long count = o == null ? 0 : (Long) o;
//								((Pages) pages).setTotalRow(count.intValue());
//							}

							Criteria criteria = session.createCriteria(clazz);
							criteria.setCacheable(cacheable);
							criteria = CriteriaHandler.processCriteria(criteria, null, container.getAssemble(), container.getColumnEntrys(), container.getGroupEntrys(), container.getOrders(), container.getPropertyChainBean());
//							if (pages != null) {
//								criteria.setFirstResult(pages.getFirstRow() - 1);
//								criteria.setMaxResults(pages.getPageSize());
//							}

							if (returnClazz == null) {
								criteria = criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
							} else {
								criteria = criteria.setResultTransformer(Transformers.aliasToBean(returnClazz));
							}

							List<T> result = criteria.list();

							return new QueryResult<T>(result, null);
						}
					});

			return (QueryResult<T>) result;
		}

		return null;
	}

	private Session getSession() {
        // 事务必须是开启的(Required)，否则获取不到
        return this.getSessionFactory().getCurrentSession();
    }

	private Criteria createCriteria(Class<? extends BasePojo> clazz, boolean cacheable) {
		return this.getSession().createCriteria(clazz).setCacheable(cacheable);
	}
}