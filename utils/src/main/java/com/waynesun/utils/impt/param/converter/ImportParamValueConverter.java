package com.waynesun.utils.impt.param.converter;

import org.apache.poi.ss.usermodel.Cell;

/**
 * 导入入参转换器接口
 * @author wayne
 *
 */
public interface ImportParamValueConverter {
	public Object getValue(Object entity,Cell cell,Class<?> propertyType,String propertyShowNameKey,int rowNum);
	public Object getValue(Object entity,Cell cell,Class<?> propertyType,String propertyShowNameKey,int rowNum,int convertType);
}
