package com.waynesun.common.biz.user;

import java.util.List;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;

/**
 * @ClassName: FtpUserUtils
 * @Description: FtpUser工具
 *
 */
public class FtpUserUtils {

	public static List<FtpUser> findFtpUsers(FtpUserQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(FtpUser.class, null, sq, true).getResults();
	}
}