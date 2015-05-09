package com.waynesun.pojo.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import com.waynesun.pojo.PojoState;

/**
 * Title: 宝冶二期<br>
 * Description:<br>
 * Copyright: Copyright &copy; Steel Bright Intelligence 2006<br>
 * Company: 1703 Studio<br>
 * create date：2006-6-20<br>
 * 
 * 为PojoState定义的Hibernate持久化类型
 * 
 * @author  
 * @version: 1.0
 */
public class PojoStateType implements UserType, Serializable
{
	private static final long serialVersionUID = -2310853620644161693L;

	public int[] sqlTypes()
	{
		// TODO 自动生成方法存根
		return new int[] { Types.INTEGER };
	}

	public Class<PojoState> returnedClass()
	{
		// TODO 自动生成方法存根
		return PojoState.class;
	}

	public boolean equals(Object x, Object y) throws HibernateException
	{
		// TODO 自动生成方法存根
		return x == y;
	}

	public int hashCode(Object x) throws HibernateException
	{
		// TODO 自动生成方法存根
		return x.hashCode();
	}

	public Object deepCopy(Object value) throws HibernateException
	{
		// TODO 自动生成方法存根
		return value;
	}

	/**
	 * PojoState是不可变的类
	 */
	public boolean isMutable()
	{
		// TODO 自动生成方法存根
		return false;
	}

	public Serializable disassemble(Object value) throws HibernateException
	{
		// TODO 自动生成方法存根
		return ((PojoState) value).getState();
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException
	{
		// TODO 自动生成方法存根
		int x = (Integer) cached;
		return PojoState.valueOf(x);
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException
	{
		// TODO 自动生成方法存根
		return original;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor arg2, Object owner) throws HibernateException,
			SQLException {
		int x = rs.getInt(names[0]);
		PojoState ps = PojoState.valueOf(x);
		return ps;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor arg3) throws HibernateException, SQLException {
		st.setInt(index, ((PojoState) value).getState());
	}
}
