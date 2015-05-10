package com.waynesun.common.biz.user;

import java.util.List;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;

/**
 * @ClassName: LoginAccountUtils
 * @Description: LoginAccount工具
 *
 */
public class LoginAccountUtils {

	public static LoginAccount findLoginAccount(LoginAccountQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().uniqueResult(LoginAccount.class, sq, true);
	}

	public static List<LoginAccount> findAllLoginAccounts() {
		return DaoFactory.getInstance().getQueryDao().list(LoginAccount.class, null, new SimpleQuery(), true).getResults();
	}
}