package com.waynesun.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtil
{
	public static String join(Collection<String> collection, String delim)
	{
		StringBuffer sb = new StringBuffer();
		if (collection != null)
		{
			for (String str : collection)
			{
				sb.append(str);
				sb.append(delim);
			}
			if (sb.length() > 0)
				sb.delete(sb.length() - 1 - delim.length(), sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * 若集合为空或size小于等于0返回true，否则返回fasle
	 * 
	 * @param collection
	 * @return
	 */
	public static boolean isEmptyOrZero(Collection<?> collection)
	{
		if (collection == null || collection.size() <= 0)
			return true;
		return false;
	}

	/**
	 * 将传递过来的List集合按长度分割
	 * 
	 * @param length
	 *            长度
	 * @param list
	 *            集合
	 * @return List<List<?>>
	 */
	public static List<List<?>> getSubList(int length, List<?> list)
	{
		List<List<?>> splitList = new ArrayList<List<?>>();
		for (int i = 0; i < list.size(); i += length)
		{
			int j = i + length;
			if (list.size() > j)
				splitList.add(list.subList(i, j));
			else
				splitList.add(list.subList(i, list.size()));
		}
		return splitList;
	}
}
