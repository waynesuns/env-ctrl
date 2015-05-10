package com.waynesun.common.biz.announcement;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;


public class AnnouncementReadStatusType implements UserType,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 955011095767246327L;

	@Override
	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		int x = (Integer) arg0;
		return AnnouncementReadStatus.valueOf(x);
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return ((AnnouncementReadStatus)arg0).getStatus();
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0.hashCode();
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Class<AnnouncementReadStatus> returnedClass() {
		// TODO Auto-generated method stub
		return AnnouncementReadStatus.class;
	}

	@Override
	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		return new int[] { Types.INTEGER };
	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String[] arg1,
			SessionImplementor arg2, Object arg3) throws HibernateException,
			SQLException {
		int x = arg0.getInt(arg1[0]);
		AnnouncementReadStatus ps = AnnouncementReadStatus.valueOf(x);
		return ps;
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2,
			SessionImplementor arg3) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		arg0.setInt(arg2, ((AnnouncementReadStatus) arg1).getStatus());
	}

}
