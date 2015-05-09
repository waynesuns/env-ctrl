package com.waynesun.utils.impt.param.excel;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.usermodel.Row;

import com.waynesun.exception.BizException;
import com.waynesun.utils.StringUtil;
import com.waynesun.utils.excel.ExcelUtil;
import com.waynesun.utils.impt.param.converter.EmptyValueConverter;
import com.waynesun.utils.impt.param.converter.ImportParamValueConverter;
import com.waynesun.utils.impt.param.validator.ImportParamAfterValidator;
import com.waynesun.utils.impt.param.validator.ImportParamBeforeValidator;
import com.waynesun.utils.impt.param.validator.ImportParamValidator;

public class ExcelImportParam implements ExcelImportParamter{
	/**赋值类型（直接赋值）*/
	public static final int PROPERTY_VALUE_TYPE_DEFAULT = 1;
	/**赋值类型（静态方法调用（单元格内的数据将被作为参数传入））*/
	public static final int PROPERTY_VALUE_TYPE_STATIC_METHOD_INVOKE = 2;
	/**验证类型（不作验证）*/
	public static final int VALIDATE_TYPE_EMPTY = 1;
	/**验证类型（方法调用（单元格内的数据将被作为参数传入））*/
	public static final int VALIDATE_TYPE_METHOD = 2;
	/**验证类型（正则表达式）*/
	public static final int VALIDATE_TYPE_STRING_MATCH = 3;
	/**数据所在excel单元格下标*/
	private int cellIndex;
	/**需要被赋值的属性名称*/
	private String propertyName;
	/**空值的替换值*/
	private Object nullValue;
	/**前置验证器列表(设值前执行)*/
	private ImportParamBeforeValidator[] beforeValidators ;
	private List<ImportParamValidator> validators = new ArrayList<ImportParamValidator>();
	/**后置验证器列表(设值后执行，用以进行多属性联合验证)*/
	private ImportParamAfterValidator afterValidator ;
	/**数值转换器*/
	private ImportParamValueConverter valueConverter;
	/**属性中问名称的资源文件KEY*/
	private String propertyShowNameKey;
	/**轉換類型*/
	private int convertType;

	public ExcelImportParam(String propertyShowNameKey,int cellIndex,String propertyName,Object nullValue,ImportParamValueConverter valueConverter,ImportParamBeforeValidator[] beforeValidators,ImportParamAfterValidator afterValidator,ImportParamValidator...  validators){
		this(propertyShowNameKey, cellIndex, propertyName, nullValue, valueConverter, StringUtil.CONVERT_TYPE_EMPTY, beforeValidators, afterValidator, validators);
	}

	public ExcelImportParam(String propertyShowNameKey,int cellIndex,String propertyName,Object nullValue,ImportParamValueConverter valueConverter,List<ImportParamBeforeValidator> beforeValidators,ImportParamAfterValidator afterValidator,ImportParamValidator...  validators){
		this(propertyShowNameKey, cellIndex, propertyName, nullValue, valueConverter, StringUtil.CONVERT_TYPE_EMPTY, beforeValidators==null?null:beforeValidators.toArray(new ImportParamBeforeValidator[beforeValidators.size()]), afterValidator, validators);
	}

	public ExcelImportParam(String propertyShowNameKey,int cellIndex,String propertyName,Object nullValue,ImportParamValueConverter valueConverter,int convertType,List<ImportParamBeforeValidator> beforeValidators,ImportParamAfterValidator afterValidator,ImportParamValidator...  validators){
		this(propertyShowNameKey, cellIndex, propertyName, nullValue, valueConverter, convertType, beforeValidators==null?null:beforeValidators.toArray(new ImportParamBeforeValidator[beforeValidators.size()]), afterValidator, validators);
	}
	public ExcelImportParam(String propertyShowNameKey,int cellIndex,String propertyName,Object nullValue,ImportParamValueConverter valueConverter,int convertType,ImportParamBeforeValidator[] beforeValidators,ImportParamAfterValidator afterValidator,ImportParamValidator...  validators){
		this.propertyShowNameKey = propertyShowNameKey;
		this.cellIndex = cellIndex;
		this.propertyName = propertyName;
		this.nullValue = nullValue;
		this.beforeValidators = beforeValidators;
		this.validators.addAll(Arrays.asList(validators));
		this.afterValidator=afterValidator;
		this.convertType = convertType;
		if(valueConverter==null){
			this.valueConverter = EmptyValueConverter.getInstance();
		}else{
			this.valueConverter = valueConverter;
		}
	}
	
	/**
	 * 设置值
	 * @param entity
	 * @param row
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
	public void setValue(Object entity,Row row) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		if(row == null){
			//若excel行为空则抛出异常
			throw new BizException("excelCellImportParam,row is null");
		}
		if(entity == null){
			//若设值的实体为空则抛出异常
			throw new BizException("excelCellImportParam,entity is null");
		}
		
		
		//获取属性类型
		Class<?> propertyType = PropertyUtils.getPropertyType(entity,propertyName);
		
		Object value = ExcelUtil.getCellValue(row.getCell(cellIndex),convertType);
		if(this.beforeValidators!=null){
			for(ImportParamBeforeValidator validator : this.beforeValidators){
				validator.doValidate(entity, value, row.getRowNum()+1);
			}
		}
		
		
		//获取属性值
		Object cellValue = this.valueConverter.getValue(entity, row.getCell(cellIndex), propertyType, propertyShowNameKey, row.getRowNum()+1);
		
		if(cellValue==null && nullValue != null){
			//若属性值为空且nullvalue不为空则将nullvalue作为属性值
			cellValue = nullValue;
		}
		if(this.validators!=null){
		for(ImportParamValidator validator : this.validators){
			validator.doValidate(entity, cellValue, row.getRowNum()+1);
		}
		}
		//设置值
		PropertyUtils.setProperty(entity, propertyName, cellValue);
		if(afterValidator!=null)
			afterValidator.doValidate(entity, cellValue, row.getRowNum()+1);
	}
	
}
