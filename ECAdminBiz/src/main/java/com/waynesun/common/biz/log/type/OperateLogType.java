package com.waynesun.common.biz.log.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class OperateLogType implements Serializable, UserType
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -503491586418487432L;

	@Override
	public Object assemble(Serializable arg0, Object arg1) throws HibernateException
	{
		int x = (Integer) arg0;
		return com.waynesun.common.biz.log.OperateLogType.valueOf(x);
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException
	{
		return arg0;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException
	{
		return ((com.waynesun.common.biz.log.OperateLogType) arg0).getStatus();
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException
	{
		return arg0 == arg1;
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException
	{
		return arg0.hashCode();
	}

	@Override
	public boolean isMutable()
	{
		return false;
	}

	@Override
	public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException
	{
		return arg0;
	}

	@Override
	public Class<com.waynesun.common.biz.log.OperateLogType> returnedClass()
	{
		return com.waynesun.common.biz.log.OperateLogType.class;
	}

	@Override
	public int[] sqlTypes()
	{
		return new int[] { Types.INTEGER };
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		int x = rs.getInt(names[0]);
		com.waynesun.common.biz.log.OperateLogType mt = com.waynesun.common.biz.log.OperateLogType.valueOf(x);
		return mt;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		st.setInt(index, ((com.waynesun.common.biz.log.OperateLogType) value).getStatus());
	}
}