package com.waynesun.common.biz.ftpfile;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.waynesun.utils.file.AbstractFile;

public class FileDaoSupport extends HibernateDaoSupport{
	public void saveFtpFile(AbstractFile file){
		getHibernateTemplate().save(file);
	}
}
