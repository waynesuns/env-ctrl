package com.waynesun.utils;

import java.util.Collection;

import org.apache.cxf.common.util.StringUtils;
/**
 * 字符串工具类
 * @author wayne
 *
 */
public class StringUtil {
	/**不进行转换*/
	public static final int CONVERT_TYPE_EMPTY = 1;
	/**都转换为小写*/
	public static final int CONVERT_TYPE_LOWER_CASE = 2;
	/**全都转换为大写*/
	public static final int CONVERT_TYPE_UPPER_CASE = 3;
	/**
	 * 去除字符串的前后空格
	 * @param str
	 * @return
	 */
	public static String doTrim(String str){
		return StringUtil.doTrim(str, StringUtil.CONVERT_TYPE_EMPTY);
	}
	/**
	 * 去除字符串的前后空格并转换字符串的大/小写
	 * @param str
	 * @param convertType
	 * @return
	 */
	public static String doTrim(String str,int convertType){
		if(str!=null){
			String value = StringUtil.ToDBC(str).trim();
			if(!StringUtils.isEmpty(value)&& !"null".equals(str.toLowerCase())){
				switch (convertType) {
				case StringUtil.CONVERT_TYPE_LOWER_CASE:
					return value.toLowerCase();
				case StringUtil.CONVERT_TYPE_UPPER_CASE:
					return value.toUpperCase();
				default:
					return value;
				}
			}
		}
		return null;
	}
	/**
	 * 将字符串列表拼接成字符串
	 * @param strs
	 * @return
	 */
	public static String join(String[] strs){
		StringBuffer sb = new StringBuffer();
		if(strs != null){
			for(String str : strs){
				if(!StringUtils.isEmpty(str) && !"null".equals(str.toLowerCase())){
					sb.append(str);
				}
			}
		}
		String result = sb.toString();
		return StringUtils.isEmpty(result)?null:result;
	}
	/**
	 * 将字符串集合拼接为字符串
	 * @param collection 待拼接集合
	 * @param delim 分隔符
	 * @return
	 */
	public static String join(Collection<String> collection,char delim){
		StringBuffer sb = new StringBuffer();
		if(collection != null && !collection.isEmpty()){
			for(String str : collection){
				sb.append(str);
				sb.append(delim);
			}
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	/**
	 * 全角转半角
	 * @param input
	 * @return
	 */
	public static String ToDBC(String input) {
		String result = null;
		if(input!=null){
			char[] c = input.toCharArray();
			for (int i = 0; i< c.length; i++) {
				if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i]> 65280&& c[i]< 65375)
				c[i] = (char) (c[i] - 65248);
			}
			result = new String(c);
		}
		return result;
	}
}
