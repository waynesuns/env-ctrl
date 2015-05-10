package com.waynesun.common.biz.config;

import java.util.List;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;

/**
 * @ClassName: SystemConfigUtils
 * @Description: SystemConfig工具
 *
 */
public class SystemConfigUtils {

	public static List<SystemConfig> findAllSystemConfigs() {
		return DaoFactory.getInstance().getQueryDao().list(SystemConfig.class, null, new SimpleQuery(), true).getResults();
	}

	public static List<SystemConfig> findSystemConfigs(SystemConfigQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(SystemConfig.class, null, sq, true).getResults();
	}
}