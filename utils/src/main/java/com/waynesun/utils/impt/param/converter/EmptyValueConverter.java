package com.waynesun.utils.impt.param.converter;

import org.apache.poi.ss.usermodel.Cell;

import com.waynesun.utils.StringUtil;
import com.waynesun.utils.excel.ExcelUtil;

/**
 * 空转换器
 * 直接返回传入的cellValue
 * @author wayne
 *
 */
public class EmptyValueConverter implements ImportParamValueConverter{
	private static final EmptyValueConverter valueConverter = new EmptyValueConverter();
	
	private EmptyValueConverter(){
		
	}
	public static EmptyValueConverter getInstance(){
		return EmptyValueConverter.valueConverter;
	}
	@Override
	public Object getValue(Object entity,Cell cell,Class<?> propertyType,String propertyShowNameKey,int rowNum) {
		return this.getValue(entity, cell, propertyType, propertyShowNameKey, rowNum, StringUtil.CONVERT_TYPE_EMPTY);
	}
	@Override
	public Object getValue(Object entity, Cell cell, Class<?> propertyType,String propertyShowNameKey, int rowNum, int convertType) {
		return ExcelUtil.getCellValue(cell, propertyType, propertyShowNameKey, rowNum,convertType);
	}

}
