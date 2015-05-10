package com.waynesun.common.biz.announcement;

import java.util.Arrays;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.order.Order;
import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.pojo.Pages;

public class AnnouncementAuthConfUtils {

	public static QueryResult<DealerAnnouncementAuthConf> getAnnouncementByDealer(String dealerId, Pages pages) {
		DealerAnnouncementAuthConfQC qc=new DealerAnnouncementAuthConfQC();
		qc.setAnnouncement_released(true);
		qc.setDealer_id(dealerId);
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(Order.desc("announcement.releaseDate")));
		return DaoFactory.getInstance().getQueryDao().list(DealerAnnouncementAuthConf.class, pages, sq, true);
	}	
}