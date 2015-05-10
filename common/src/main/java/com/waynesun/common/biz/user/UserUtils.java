package com.waynesun.common.biz.user;

import java.util.Arrays;
import java.util.List;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.order.Order;
import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.pojo.Pages;

/**
 * @ClassName: UserUtils
 * @Description: User工具
 *
 */
public class UserUtils {

	public static List<AbstractUser> findAllUsers() {
		return DaoFactory.getInstance().getQueryDao().list(AbstractUser.class, null, new SimpleQuery(), true).getResults();
	}

	public static List<AbstractUser> findUsers(UserQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(AbstractUser.class, null, sq, true).getResults();
	}

	public static QueryResult<AbstractUser> findUsers(UserQC qc, Pages pages) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(Order.asc("name")));
		return DaoFactory.getInstance().getQueryDao().list(AbstractUser.class, pages, sq, true);
	}

	public static AbstractUser findUser(String dealerCode, String userName) {
		UserQC qc = new UserQC();
		qc.setDealer_dealerCode(dealerCode);
		qc.setAccount_userName(userName);
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().uniqueResult(AbstractUser.class, sq, true);
	}
}