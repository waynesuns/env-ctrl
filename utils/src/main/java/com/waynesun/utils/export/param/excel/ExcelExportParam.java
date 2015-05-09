package com.waynesun.utils.export.param.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;

import com.waynesun.utils.export.param.ExportParam;
import com.waynesun.utils.export.param.ExportParamInterType;
import com.waynesun.utils.export.param.ExportParamValueType;

public class ExcelExportParam extends ExportParam{
	private HSSFCellStyle style;
	
	public ExcelExportParam(ExportParamValueType titleType,ExportParamValueType valueType,Object nullValue){
		super(titleType, valueType, nullValue);
	}
	public ExcelExportParam(ExportParamValueType titleType,ExportParamInterType titleInterType,ExportParamValueType valueType,Object nullValue){
		super(titleType, titleInterType, valueType, nullValue);
	}
	public ExcelExportParam(ExportParamValueType titleType,ExportParamValueType valueType,ExportParamInterType valueInterType){
		super(titleType, valueType, valueInterType, null);
	}
	
	public ExcelExportParam(ExportParamValueType titleType,ExportParamValueType valueType,ExportParamInterType valueInterType,Object nullValue){
		super(titleType, valueType, valueInterType, nullValue);
	}
	public ExcelExportParam(ExportParamValueType titleType,ExportParamInterType titleInterType,ExportParamValueType valueType,ExportParamInterType valueInterType){
		super(titleType, titleInterType, valueType, valueInterType,null);
	}
	public ExcelExportParam(ExportParamValueType titleType,ExportParamInterType titleInterType,ExportParamValueType valueType,ExportParamInterType valueInterType,Object nullValue){
		super(titleType, titleInterType, valueType, valueInterType, nullValue);
	}
	public ExcelExportParam(ExportParamValueType titleType,ExportParamValueType valueType,Object nullValue,HSSFCellStyle style){
		super(titleType, valueType, nullValue);
		this.style = style;
	}
	public ExcelExportParam(ExportParamValueType titleType,ExportParamInterType titleInterType,ExportParamValueType valueType,Object nullValue,HSSFCellStyle style){
		super(titleType, titleInterType, valueType, nullValue);
		this.style = style;
	}
	public ExcelExportParam(ExportParamValueType titleType,ExportParamValueType valueType,ExportParamInterType valueInterType,Object nullValue,HSSFCellStyle style){
		this(titleType, valueType, valueInterType, nullValue);
		this.style = style;
	}
	public ExcelExportParam(ExportParamValueType titleType,ExportParamInterType titleInterType,ExportParamValueType valueType,ExportParamInterType valueInterType,Object nullValue,HSSFCellStyle style){
		super(titleType, titleInterType, valueType, valueInterType, nullValue);
		this.style = style;
	}
	public HSSFCellStyle getStyle() {
		return style;
	}
	public void setStyle(HSSFCellStyle style) {
		this.style = style;
	}
	
	
}
