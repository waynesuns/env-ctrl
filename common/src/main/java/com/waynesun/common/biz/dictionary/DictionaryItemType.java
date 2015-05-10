package com.waynesun.common.biz.dictionary;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class DictionaryItemType implements UserType, Serializable
{
	private static final long serialVersionUID = -2310853620644161693L;

	public int[] sqlTypes()
	{
		// TODO 自动生成方法存根
		return new int[] { Types.NUMERIC };
	}

	public Class<DictionaryItem> returnedClass()
	{
		// TODO 自动生成方法存根
		return DictionaryItem.class;
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

	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor arg2,Object owner) throws HibernateException, SQLException
	{
		// TODO 自动生成方法存根
		DictionaryItem ps = DictionaryCacheUtils.getDictionaryItemById(rs.getString(names[0]));
		return ps;
	}
	public void nullSafeSet(PreparedStatement st, Object value, int index,SessionImplementor arg2) throws HibernateException, SQLException
	{
		// TODO 自动生成方法存根
		if(value==null){
			st.setString(index, null);
		}else{
			st.setString(index, ((DictionaryItem) value).getId());
		}
		//st.setString(index, ((DictionaryItem) value).getId());
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
		if(value==null)
			return null;
		return ((DictionaryItem) value).getId();
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException
	{
		// TODO 自动生成方法存根
		String id = (String) cached;
		return DictionaryCacheUtils.getDictionaryItemById(id);
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException
	{
		// TODO 自动生成方法存根
		return original;
	}


}
