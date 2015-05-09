package com.waynesun.utils.impt.param.excel;

import java.lang.reflect.InvocationTargetException;

import org.apache.poi.ss.usermodel.Row;

public interface ExcelImportParamter {
	public void setValue(Object entity,Row row) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException;
}
