package com.waynesun.dao;

import com.waynesun.utils.SpringContextUtil;

public class DaoFactory {
	private MaintainDao maintainDao;
	private QueryDao queryDao;
	
	public static DaoFactory getInstance(){
		return (DaoFactory)SpringContextUtil.getBean("daoFactory");
	}
	public MaintainDao getMaintainDao() {
		return maintainDao;
	}
	public void setMaintainDao(MaintainDao maintainDao) {
		this.maintainDao = maintainDao;
	}
	public QueryDao getQueryDao() {
		return queryDao;
	}
	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}
	
	
}
