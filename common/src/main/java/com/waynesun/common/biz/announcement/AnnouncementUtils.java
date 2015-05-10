package com.waynesun.common.biz.announcement;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.cxf.common.util.StringUtils;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.order.Order;
import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.pojo.Pages;
import com.waynesun.utils.DateUtils;

public class AnnouncementUtils {

	public static List<Announcement> findAnnouncementAll()
	{
		return DaoFactory.getInstance().getQueryDao().list(Announcement.class,null,new SimpleQuery(),true).getResults();
	}
	
	public static List<Announcement> findAnnouncementIsReleased(AnnouncementQC qc)
	{
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(Order.desc("releaseDate"),Order.desc("id")));
		return DaoFactory.getInstance().getQueryDao().list(Announcement.class, null, sq, true).getResults();
	}
	
	public static QueryResult<Announcement> getAnnouncementByQC(AnnouncementQC qc, Pages pages)
	{
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(Order.desc("releaseDate"),Order.desc("id")));
		if (qc == null)
			return DaoFactory.getInstance().getQueryDao().list(Announcement.class, null, sq, true);
		return DaoFactory.getInstance().getQueryDao().list(Announcement.class, pages, sq, true);
	}
	/**
	 * 获取公告编号, 当前日期+序号,从1开始,日期格式为yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static String getSerialNumber() throws ParseException{
		AnnouncementQC qc=new AnnouncementQC();
		String time = DateUtils.toString(new Date()); 
		String startSerial = DateUtils.format(new Date(), "yyyyMMdd");
		qc.setCreateTime_start(DateUtils.parseDate(time+" 00:00:00","yyyy-MM-dd HH:mm:ss"));
		qc.setCreateTime_end(DateUtils.parseDate(time+" 23:59:59","yyyy-MM-dd HH:mm:ss"));
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(Order.desc("id")));
		Announcement an = DaoFactory.getInstance().getQueryDao().uniqueResult(Announcement.class, sq, true);
		if(an!=null&&!StringUtils.isEmpty(an.getSerialNumber())){
			String seriValue = an.getSerialNumber();
			int num = Integer.parseInt(seriValue.replace(startSerial, ""));
			String numStr = ++num+"";
			int length = numStr.length();
			for (int i = length; i < 3; i++) {
				numStr = "0" + numStr;
			}
			return startSerial + numStr; 
		}else{
			return startSerial + "01"; 
		}
	}
}
