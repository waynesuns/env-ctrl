package com.waynesun.common.biz.role;

import java.util.Arrays;
import java.util.List;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.order.Order;
import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.pojo.Pages;

/**
 * @ClassName: RoleUtils
 * @Description: Role工具
 */
public class RoleUtils {

	public static List<Role> findAllRoles() {
		return DaoFactory.getInstance().getQueryDao().list(Role.class, null, new SimpleQuery(), true).getResults();
	}

	public static List<Role> findRoles(RoleQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(Role.class, null, sq, true).getResults();
	}

	public static QueryResult<Role> findRoles(RoleQC qc, Pages pages) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(Order.asc("name")));
		return DaoFactory.getInstance().getQueryDao().list(Role.class, pages, sq, true);
	}
}