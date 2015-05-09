package com.waynesun.utils.impt.param.converter;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.poi.ss.usermodel.Cell;

import com.waynesun.exception.BizException;
import com.waynesun.utils.StringUtil;
import com.waynesun.utils.excel.ExcelUtil;

/**
 * 静态方法转换器
 * 将cellValue作为参数调用指定的静态方法获取返回值
 * @author wayne
 *
 */
public class StaticMethodValueConverter implements ImportParamValueConverter{
	/**类名*/
	private String className;
	/**方法名*/
	private String methodName;
	public StaticMethodValueConverter(String className,String methodName){
		this.className = className;
		this.methodName = methodName;
	}
	@Override
	public Object getValue(Object entity, Cell cell,Class<?> propertyType,String propertyShowNameKey,int rowNum) {
		return this.getValue(entity, cell, propertyType, propertyShowNameKey, rowNum, StringUtil.CONVERT_TYPE_EMPTY);
	}
	@Override
	public Object getValue(Object entity, Cell cell, Class<?> propertyType,String propertyShowNameKey, int rowNum, int convertType) {
		if(className==null){
			throw new BizException("excelCellImportParam,className is null");
		}
		if(methodName==null){
			throw new BizException("excelCellImportParam,methodName is null");
		}
		Object value = ExcelUtil.getCellValue(cell, propertyType, propertyShowNameKey, rowNum,convertType);
		if(value==null)
			return null;
		try {
			return MethodUtils.invokeStaticMethod(Class.forName(className),methodName, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
