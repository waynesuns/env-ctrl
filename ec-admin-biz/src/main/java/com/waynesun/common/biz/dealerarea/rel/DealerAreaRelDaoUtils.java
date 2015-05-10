package com.waynesun.common.biz.dealerarea.rel;

import java.util.List;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;

/**
 * @ClassName: DealerAreaRelDaoUtils
 * @Description: 省市区级联同经销商区域的中间表工具
 *
 */
public class DealerAreaRelDaoUtils {

	/**
	 * @Description: 根据条件查询
	 * @param qc
	 * @return List<DealerAreaRel>
	 */
	public static List<DealerAreaRel> findDealerAreaRels(DealerAreaRelQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(DealerAreaRel.class, null, sq, true).getResults();
	}
}