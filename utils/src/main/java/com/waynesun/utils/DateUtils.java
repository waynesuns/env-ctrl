package com.waynesun.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

/**
 * Title: 宝冶二期<br>
 * Description:<br>
 * Copyright: Copyright (c) Steel Bright Intelligence 2006<br>
 * Company: 1703 Studio<br>
 * create date：2006-8-9<br>
 * 操作日期的工具类
 * 
 * @author
 * @version: 1.0
 */
public final class DateUtils
{
	/**
	 * yyyy-MM-dd
	 */
	public static final SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * yyMM
	 */
	public static final SimpleDateFormat YYMM = new SimpleDateFormat("yyMM");

	public static final Integer SUN_WEEK = 7;
	public static final Integer MON_WEEK = 1;
	public static final Integer TUE_WEEK = 2;
	public static final Integer WED_WEEK = 3;
	public static final Integer THU_WEEK = 4;
	public static final Integer FRI_WEEK = 5;
	public static final Integer SAT_WEEK = 6;

	/**
	 * 每天24小时一共有的毫秒数
	 */
	public static final long DAY_TIME_NUMBER = 1000 * 60 * 60 * 24;

	/**
	 * 把日期类型转换成yyyy-MM-dd格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static final String toString(Date date)
	{
		return YYYY_MM_DD.format(date);
	}

	/**
	 * 返回当前的年份月份组成的字符串
	 * 
	 * @return
	 */
	public static final String currentYYMM()
	{
		return YYMM.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 把日期类型转换成yyyy-MM-dd mm:HH:ss格式的字符串
	 * 
	 * @return
	 */
	public static final String format()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.YYYY_MM_DD_HH_MM_SS.toPattern());
		return sdf.format(new Date());
	}

	/**
	 * 把日期类型转换成yyyy-MM-dd格式的字符串
	 * 
	 * @param format
	 * @return
	 */
	public static final String format(String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	/**
	 * 把日期类型转换成yyyy-MM-dd格式的字符串
	 * 
	 * @param format
	 * @param date
	 * @return
	 */
	public static final String format(Date date, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date getDateByDayOfWeek(int dayOfWeek)
	{
		return DateUtils.getDateByDayOfWeek(dayOfWeek, Calendar.getInstance());
	}

	public static Date getDateByDayOfWeek(int dayOfWeek, Calendar calendar)
	{
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		return calendar.getTime();
	}

	public static Date getFirstDateOfMonth(Calendar calendar)
	{
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	public static Date getLastDateOfMonth(Calendar calendar)
	{
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	public static Date getToday()
	{
		return org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DATE);
	}

	public static boolean isOvertime(Date dualDate)
	{
		return DateUtils.isOvertime(dualDate, new Date());
	}

	public static boolean isOvertime(Date dualDate, Date destTag)
	{
		if (dualDate == null || destTag == null)
			return false;
		return (!org.apache.commons.lang.time.DateUtils.isSameDay(dualDate, destTag)) && destTag.after(dualDate);
	}

	public static Date getDateByDay(int numberOfDays)
	{
		return getDateByDay(new Date(), numberOfDays);
	}

	public static Date getDateByDay(Date date, int numberOfDays)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, numberOfDays);
		return calendar.getTime();
	}

	/**
	 * 根据日期格式，显示日期
	 * 
	 * @param date
	 *            日期（完整的）
	 * @param format
	 *            格式化（例如：yyyy-MM-dd只显示年月日，或者HH:mm:ss只显示时分秒）
	 * @return
	 */
	public static String getDataStrByFormat(Date date, String format)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * 根据年月日判断星期几，返回int，7=星期天，1=星期一
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param date
	 *            日
	 * @return
	 */
	public static int getWeekByYMD(int year, int month, int date)
	{
		GregorianCalendar gc = new GregorianCalendar();
		final Integer[] kor_week = { SUN_WEEK, MON_WEEK, TUE_WEEK, WED_WEEK, THU_WEEK, FRI_WEEK, SAT_WEEK };
		gc.set(year, month - 1, date);
		int week = kor_week[gc.get(Calendar.DAY_OF_WEEK) - 1];
		return week;
	}

	/**
	 * 根据日期字符创转换成对应格式的日期
	 * 
	 * @param dateTime
	 * @param formatStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateTime, String formatStr) throws ParseException
	{
		SimpleDateFormat format = null;
		format = new SimpleDateFormat("yyyy-MM-dd");
		if (!StringUtils.isEmpty(formatStr))
			format = new SimpleDateFormat(formatStr);
		Date date = format.parse(dateTime);
		return date;
	}

	/**
	 * 获取几天前或几天后的凌晨日期
	 * 
	 * @param number
	 *            若为正整数则获取几天后的日期，反之后去几天前的日期
	 * 
	 * @return 日期，例：2012-01-01 00:00:00
	 * @throws ParseException
	 */
	public static Date getDateStartByNumber(int number) throws ParseException
	{
		Calendar calendar = Calendar.getInstance();
		Date currentDate = DateUtils.parseDate(DateUtils.format(calendar.getTime(), YYYY_MM_DD.toPattern()), YYYY_MM_DD.toPattern());
		calendar.setTimeInMillis(currentDate.getTime() + (DAY_TIME_NUMBER * number));
		return calendar.getTime();
	}

	/**
	 * 获取几天前或几天后的午夜日期
	 * 
	 * @param number
	 *            若为正整数则获取几天后的日期，反之后去几天前的日期
	 * 
	 * @return 日期，例：2012-01-01 23:59:59
	 * @throws ParseException
	 */
	public static Date getDateEndByNumber(int number) throws ParseException
	{
		Calendar calendar = Calendar.getInstance();
		Date currentDate = DateUtils.parseDate(DateUtils.format(calendar.getTime(), YYYY_MM_DD.toPattern()), YYYY_MM_DD.toPattern());
		calendar.setTimeInMillis(currentDate.getTime() + (DAY_TIME_NUMBER * (number + 1)) - 1);
		return calendar.getTime();
	}

	/**
	 * 获取当前月份（1月=1,2月=3以此类推）
	 * 
	 * @return 返回数字类型的月份
	 */
	public static int getCurrentMonth()
	{
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取当前是几号（1号：1,2号：2以此类推）
	 * 
	 * @return
	 */
	public static int getCurrentDay()
	{
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 返回当前日期是星期几，（周一：1，周二：2，周三：3，周四：4，周五：5，周六：6，周日：0）
	 * 
	 * @return 返回数字类型的星期数
	 */
	public static int getCurrentWeek()
	{
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_WEEK)-1;
	}

	/**可接受的日期格式，必须由大到小（日期+时分秒>只有日期）排*/
	private static String[] parsePatterns = new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm","yyyy-MM-dd","yyyy/MM/dd"};
	public static Date parseDate(String dateStr) throws ParseException{
		if(dateStr==null || StringUtils.isEmpty(dateStr) || "".equals(dateStr.trim())){
			return null;
		}
		return org.apache.commons.lang.time.DateUtils.parseDate(dateStr.trim(), parsePatterns);
	}

	/**
	 * @param time
	 * @param type
	 * @return
	 */
	public static Date truncate(Date time,int type){
		if(time==null){
			time = new Date();
		}
		return org.apache.commons.lang.time.DateUtils.truncate(time, type);
	}

	/**
	 * 验证字符串是否符合日期格式
	 * @param dateStr
	 * @return
	 */
	public static boolean isValidDateStr(String dateStr){
		if(StringUtils.isEmpty(dateStr)){
			return false;
		}
		try {
			DateUtils.parseDate(dateStr);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * @Title: isSameDay
	 * @Description: 是否在同一天
	 * @param date1
	 * @param date2
	 * @return boolean
	 * @throws
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		return org.apache.commons.lang.time.DateUtils.isSameDay(date1, date2);
	}

	/**
	 * 得到<code>date</code>在<code>days</code>天后的起止时间
	 * 负数表示几天前
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date[] getDateRangeOfDay(Date date, int days) {
		Calendar beginCld = Calendar.getInstance();
		beginCld.setTime(date);
		beginCld.add(Calendar.DAY_OF_YEAR, days);
		setMinimumOfDay(beginCld);

		Calendar endCld = Calendar.getInstance();
		endCld.setTime(date);
		endCld.add(Calendar.DAY_OF_YEAR, days);
		setMaximumOfDay(endCld);

		return new Date[]{beginCld.getTime(), endCld.getTime()};
	}

	/**
	 * @Description: 得到当天最小时间
	 * @param date
	 * @return void
	 */
	public static Date getMinimumOfDay(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		setMinimumOfDay(cld);
		return cld.getTime();
	}

	/**
	 * @Description: 得到当天最大时间
	 * @param date
	 * @return void
	 */
	public static Date getMaximumOfDay(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		setMaximumOfDay(cld);
		return cld.getTime();
	}

	private static void setMinimumOfDay(Calendar cld) {
		cld.set(Calendar.HOUR_OF_DAY, cld.getActualMinimum(Calendar.HOUR_OF_DAY));
		cld.set(Calendar.MINUTE, cld.getActualMinimum(Calendar.MINUTE));
		cld.set(Calendar.SECOND, cld.getActualMinimum(Calendar.SECOND));
		cld.set(Calendar.MILLISECOND, cld.getActualMinimum(Calendar.MILLISECOND));
	}

	private static void setMaximumOfDay(Calendar cld) {
		cld.set(Calendar.HOUR_OF_DAY, cld.getActualMaximum(Calendar.HOUR_OF_DAY));
		cld.set(Calendar.MINUTE, cld.getActualMaximum(Calendar.MINUTE));
		cld.set(Calendar.SECOND, cld.getActualMaximum(Calendar.SECOND));
		cld.set(Calendar.MILLISECOND, cld.getActualMaximum(Calendar.MILLISECOND));
	}
}