package com.waynesun.common.biz.announcement;

import java.util.List;



import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;

public class DealerAnnouncementAuthConfUtils  {
	public static List<DealerAnnouncementAuthConf> getDealerAnnouncementAuthConfByQc(DealerAnnouncementAuthConfQC qc){
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(DealerAnnouncementAuthConf.class, null, sq, true).getResults();
	}
}
