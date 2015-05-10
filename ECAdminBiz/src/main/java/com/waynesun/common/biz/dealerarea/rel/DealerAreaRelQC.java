package com.waynesun.common.biz.dealerarea.rel;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;

/**
 * @ClassName: DealerAreaRelQC
 * @Description: 省市区级联同经销商区域的中间表查询条件
 * @author zhengnan
 * @date 2012-11-27 下午04:56:19
 *
 */
public class DealerAreaRelQC extends BaseQueryCondition {

	private String dealerAraea_id;

	@Eq
	public String getDealerAraea_id() {
		return dealerAraea_id;
	}

	public void setDealerAraea_id(String dealerAraea_id) {
		this.dealerAraea_id = dealerAraea_id;
	}
}