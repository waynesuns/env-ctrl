package com.waynesun.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import com.waynesun.dao.query.condition.annotation.DateZone;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.dao.query.condition.annotation.Ge;
import com.waynesun.dao.query.condition.annotation.Gt;
import com.waynesun.dao.query.condition.annotation.IdEq;
import com.waynesun.dao.query.condition.annotation.IsNotNull;
import com.waynesun.dao.query.condition.annotation.IsNull;
import com.waynesun.dao.query.condition.annotation.Le;
import com.waynesun.dao.query.condition.annotation.Like;
import com.waynesun.dao.query.condition.annotation.Lt;
import com.waynesun.dao.query.condition.annotation.LtOrNull;
import com.waynesun.dao.query.condition.annotation.ParentPath;
import com.waynesun.dao.query.condition.annotation.Path;
import com.waynesun.dao.type.DaoType;

/**
 * 查询条件适配器工厂
 * @author wayne
 *
 */
public class CriterionAdapterFactory {
	/**查询条件适配器缓存*/
	private static final Map<DaoType, Map<Class<? extends Annotation>, AbstractCriterionAdapter>> ADAPTERS = new HashMap<DaoType, Map<Class<? extends Annotation>, AbstractCriterionAdapter>>();

	static{
		initHibernateCriterionAdapters();
	}

	private static void initHibernateCriterionAdapters() {
		Map<Class<? extends Annotation>, AbstractCriterionAdapter> adapterMap = new HashMap<Class<? extends Annotation>, AbstractCriterionAdapter>();
		adapterMap.put(IdEq.class, new IdEqAdapter());
		adapterMap.put(Eq.class, new EqAdapter());
		adapterMap.put(Like.class, new LikeAdapter());
		adapterMap.put(DateZone.class, new DateZoneAdapter());
		adapterMap.put(Path.class, new PathAdapter());
		adapterMap.put(IsNull.class, new IsNullAdapter());
		adapterMap.put(IsNotNull.class, new IsNotNullAdapter());
		adapterMap.put(Ge.class, new GeAdapter());
		adapterMap.put(Gt.class, new GtAdapter());
		adapterMap.put(Le.class, new LeAdapter());
		adapterMap.put(Lt.class, new LtAdapter());
		adapterMap.put(LtOrNull.class, new LtOrNullAdapter());
		adapterMap.put(ParentPath.class, new ParentPathAdapter());

		ADAPTERS.put(DaoType.HIBERNATE, adapterMap);
	}

	/**
	 * @Title: getAdapter
	 * @Description: 根据查询条件注解的类名获取对应的适配器
	 * @param daoType
	 * @param criteriaAnnotationClass
	 * @return AbstractCriterionAdapter
	 * @throws
	 */
	public static AbstractCriterionAdapter getAdapter(DaoType daoType, Class<? extends Annotation> criteriaAnnotationClass){
		return ADAPTERS.get(daoType).get(criteriaAnnotationClass);
	}	
}