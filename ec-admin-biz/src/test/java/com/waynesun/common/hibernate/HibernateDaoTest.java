package com.waynesun.common.hibernate;

import com.waynesun.dao.hibernate.HibernateDaoImpl;
import com.waynesun.common.SpringDAOTestCase;

public class HibernateDaoTest extends SpringDAOTestCase {
	private HibernateDaoImpl dao;  
	  
    protected void onSetUpInTransaction() throws Exception {  
        super.onSetUpInTransaction();
        //this.setPopulateProtectedVariables(true);;  
        dao = (HibernateDaoImpl)this.applicationContext.getBean("dao");;  
    }  
  
    protected void onTearDownInTransaction(){  
    	dao = null;  
    }  
  
    public void testGet(){  
        System.out.println(dao);
    }  
}
