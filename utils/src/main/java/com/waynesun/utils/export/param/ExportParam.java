package com.waynesun.utils.export.param;

import com.waynesun.utils.export.param.it.EmptyEPIT;


/**
 * 导出参数
 * @author wayne
 *
 */
public class ExportParam {
	/**标题参数类型*/
	private ExportParamValueType titleType; 
	/**标题国际化类型*/
	private ExportParamInterType titleInterType;
	/**值参数类型*/
	private ExportParamValueType valueType; 
	/**值国际化类型*/
	private ExportParamInterType valueInterType;
	/**空置的替换值*/
	private Object nullValue;

	public ExportParam(ExportParamValueType titleType,ExportParamValueType valueType,Object nullValue){
		this(titleType, EmptyEPIT.getInstance(), valueType, EmptyEPIT.getInstance(), nullValue);
	}
	public ExportParam(ExportParamValueType titleType,ExportParamInterType titleInterType,ExportParamValueType valueType,Object nullValue){
		this(titleType, titleInterType, valueType, EmptyEPIT.getInstance(), nullValue);
	}
	public ExportParam(ExportParamValueType titleType,ExportParamValueType valueType,ExportParamInterType valueInterType,Object nullValue){
		this(titleType, EmptyEPIT.getInstance(), valueType, valueInterType, nullValue);
	}
	public ExportParam(ExportParamValueType titleType,ExportParamInterType titleInterType,ExportParamValueType valueType,ExportParamInterType valueInterType,Object nullValue){
		this.titleType = titleType;
		this.titleInterType = titleInterType;
		this.valueType = valueType;
		this.valueInterType = valueInterType;
		this.nullValue = nullValue;
	}
	
	/**
	 * 获取标题
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public Object getTitle(Object object) throws Exception{
		return this.getValue(object, titleType, titleInterType);
	}

	/**
	 * 获取值
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public Object getValue(Object object) throws Exception{
		return this.getValue(object, valueType, valueInterType);
	}
	
	private Object getValue(Object object,ExportParamValueType valueType,ExportParamInterType interType)throws Exception{
		Object value = valueType.getValue(object);
		if(value==null){
			value = nullValue;
		}
		if(value!=null){
			return interType.getValue(value);
		}
		return value;
	}

}
