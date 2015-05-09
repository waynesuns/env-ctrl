package com.waynesun.dao.query.condition.annotation.adapter;

import java.lang.annotation.Annotation;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.waynesun.dao.query.condition.util.TimeRange;

/**
 * 日期范围注解适配器
 * @author wayne
 *
 */
public class DateZoneAdapter extends AbstractCriterionAdapter {

	@Override
	public Criterion generateCriteria(String propertyName, Object propertyValue, Annotation annotation) {
		try {
			TimeRange timeRange = (TimeRange) propertyValue;
			//获取开始日期
			Date beginDate = timeRange.getStartTime();
			//获取结束日期
			Date endDate = timeRange.getEndTime();

			return DateZoneAdapter.getDateZoneCriterion(beginDate, endDate, propertyName);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Criterion getDateZoneCriterion(Date beginDate,Date endDate,String propertyName){
		Criterion criterion = null;
		if(beginDate!=null){
			//若开始日期不为空，则将该日期的时分秒阶段，即为该日期的0点0分0秒，并以此进行日期的>=比较
			criterion = Restrictions.ge(propertyName, new Timestamp(DateUtils.truncate(beginDate, Calendar.DATE).getTime()));
		}
		if(endDate!=null){
			//若结束日期不为空，则将该日期+1天并将时分秒截断
			Calendar cal = Calendar.getInstance();
			cal.setTime(DateUtils.truncate(endDate, Calendar.DATE));
			cal.add(Calendar.DAY_OF_YEAR, 1);
			Timestamp endTime=new Timestamp(cal.getTimeInMillis());
			
			if(criterion==null){
				//若开始日期为空则使用结束日期进行<比较
				criterion = Restrictions.lt(propertyName, endTime);
			}else{
				//若开始日期不为空则将开始日期与结束日期使用and进行关联
				criterion = Restrictions.and(criterion, Restrictions.lt(propertyName, endTime));
			}
			
		}
		return criterion;
	}
}
