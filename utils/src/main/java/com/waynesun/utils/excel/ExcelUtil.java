package com.waynesun.utils.excel;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;

import com.waynesun.exception.BizException;
import com.waynesun.utils.Constant;
import com.waynesun.utils.DateUtils;
import com.waynesun.utils.ExceptionDicKeys;
import com.waynesun.utils.MessageReader;
import com.waynesun.utils.StringUtil;
import com.waynesun.utils.export.excel.DataExportUtil;


/**
 * poi 生成excel工具类
 * @author weis
 *
 */
public class ExcelUtil {
	/**
	 * 生成带样式的单元格
	 * @param workbook
	 * @param row
	 * @param index
	 * @param value
	 * @param style
	 * @return
	 */
	public static HSSFCell generateCell(HSSFWorkbook workbook,HSSFRow row,Integer index,Object value,HSSFCellStyle style){
		HSSFCell cell =  row.createCell(index);
		ExcelUtil.setCellValue(workbook,cell, value,style);
		return cell;
	}
	public static HSSFCell generateCell(HSSFWorkbook workbook,HSSFRow row,Integer index,Object value,short align){
		HSSFCell cell =  row.createCell(index);
		//cell.setEncoding(HSSFWorkbook.ENCODING_UTF_16);
		//cell.setCellValue(value==null?"":value.toString());
		ExcelUtil.setCellValue(workbook,cell, value,null);
		return cell;
	}
	public static HSSFCellStyle getCellStyle(HSSFWorkbook workbook){
		HSSFCellStyle cellStyle = DataExportUtil.CELL_STYLE.get();
		if(cellStyle==null){
			cellStyle = ExcelUtil.generateCellStyle(workbook);
			DataExportUtil.CELL_STYLE.set(cellStyle);
		}
		return cellStyle;
	}
	public static HSSFCellStyle getTitleCellStyle(HSSFWorkbook workbook){
		HSSFCellStyle cellStyle = DataExportUtil.TITLE_STYLE.get();
		if(cellStyle==null){
			cellStyle = ExcelUtil.generateTitleCellStyle(workbook);
			DataExportUtil.TITLE_STYLE.set(cellStyle);
		}
		return cellStyle;
	}
	public static HSSFCellStyle getDateCellStyle(HSSFWorkbook workbook){
		HSSFCellStyle cellStyle = DataExportUtil.DATE_CELL_STYLE.get();
		if(cellStyle==null){
			cellStyle = ExcelUtil.generateDateCellStyle(workbook);
			DataExportUtil.DATE_CELL_STYLE.set(cellStyle);
		}
		return cellStyle;
	}
	private static HSSFCellStyle generateCellStyle(HSSFWorkbook workbook){
		HSSFFont font = workbook.createFont();
		font.setFontName("微软雅黑");
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setFont(font);
		return style;
	}
	private static HSSFCellStyle generateTitleCellStyle(HSSFWorkbook workbook){
		HSSFFont font = workbook.createFont();
		font.setFontName("微软雅黑");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.DARK_BLUE.index);
		font.setFontHeight((short) 300);
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置水平对齐
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFont(font);
		return style;
	}
	private static HSSFCellStyle generateDateCellStyle(HSSFWorkbook workbook){
		return ExcelUtil.generateDateCellStyle(workbook,Constant.PATTEERN_DATE);
	}
	public static HSSFCellStyle generateDateCellStyle(HSSFWorkbook workbook,String patteern){
		HSSFCellStyle style =  workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat(patteern));
		return style;
	}
	
	/**
	 *  根据value的数据类型调用HSSFCell不同的setCellValue方法
	 * @param workbook HSSFWorkbook
	 * @param cell HSSFCell
	 * @param value 值
	 */
	private static void setCellValue(HSSFWorkbook workbook,HSSFCell cell,Object value,HSSFCellStyle style){
		cell.setCellStyle(ExcelUtil.getCellStyle(workbook));
		if(style!=null){
			cell.setCellStyle(style);
		}
		if(value instanceof Boolean){
			cell.setCellValue(((Boolean)value).booleanValue());
		}else if(value instanceof Double){
			cell.setCellValue(((Double)value).doubleValue());
		}else if(value instanceof Float){
			cell.setCellValue(((Float)value).doubleValue());
		}else if(value instanceof BigDecimal){
			cell.setCellValue(((BigDecimal)value).doubleValue());
		}else if(value instanceof Integer){
			cell.setCellValue(((Integer)value).intValue());
		}else if(value instanceof Long){
			cell.setCellValue(((Long)value).longValue());
		}else if(value instanceof Date){
			if(value!=null){
				value = DateUtils.truncate((Date)value,Calendar.MILLISECOND);
			}
			cell.setCellValue((Date)value);
			if(style==null){
				cell.setCellStyle(ExcelUtil.getDateCellStyle(workbook));
			}
		}else if(value instanceof Calendar){
			cell.setCellValue((Calendar)value);
		}else{
			cell.setCellValue(value==null?"":value.toString());
		}
	}
	

	public static Object getCellValue(Cell cell,Class<?> propertyType,String propertyShowNameKey,int rowNum,int convertType){
		Object cellValue = null;
		if(cell!=null){
			try{
				Object value = ExcelUtil.getCellValue(cell,convertType);
				if(value==null){
					return null;
				}
				if(propertyType==null){
					System.out.println(123);
				}
				if(propertyType.isAssignableFrom(Boolean.class)){
					cellValue = Boolean.valueOf(value.toString());
				}else if(propertyType.isAssignableFrom(Double.class)){
					cellValue =  Double.valueOf(value.toString());
				}else if(propertyType.isAssignableFrom(Float.class)){
					cellValue =  Float.valueOf(value.toString());
				}else if(propertyType.isAssignableFrom(BigDecimal.class)){
					cellValue = new BigDecimal(value.toString());
				}else if(propertyType.isAssignableFrom(Integer.class)){
					cellValue =  Integer.valueOf(value.toString());
				}else if(propertyType.isAssignableFrom(Long.class)){
					cellValue =  Long.valueOf(value.toString());
				}else if(propertyType.isAssignableFrom(Date.class)){
					cellValue = ExcelUtil.getDateCellValue(cell);
				}else if(propertyType.isAssignableFrom(String.class)){
					cellValue = ExcelUtil.getCellValue(cell,convertType);
				}else{
					cellValue = ExcelUtil.getCellValue(cell,convertType);
				}
			}catch (NumberFormatException e) {
				throw new BizException(ExceptionDicKeys.EXCEL_IMPORT_NUMBER_FORMAT_ERROR, MessageReader.getMessage(propertyShowNameKey),Integer.valueOf(rowNum).toString());
			}catch (ParseException e) {
				throw new BizException(ExceptionDicKeys.EXCEL_IMPORT_PARSE_ERROR, MessageReader.getMessage(propertyShowNameKey),Integer.valueOf(rowNum).toString());
			}
			
		}
		return cellValue;
	}
	

	/**
	 * 获取单元格内的值
	 * @param cell
	 * @return
	 */
	public static Object getCellValue(Cell cell,int convertType){
		if(cell!=null){
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			return null;
		default:
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			return StringUtil.ToDBC(StringUtil.doTrim(cell.getStringCellValue(),convertType));
		}
		}
		return null;
	}
	/**
	 * 获取日期类型的单元格值
	 * @param cell
	 * @return
	 * @throws ParseException 
	 */
	private static Object getDateCellValue(Cell cell) throws ParseException{
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			return null;
		case Cell.CELL_TYPE_NUMERIC:
			return cell.getDateCellValue();
		default:
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			String dateStr = StringUtil.ToDBC(StringUtil.doTrim(cell.getStringCellValue()));

			//若日期格式有效则返回日期
			return DateUtils.parseDate(dateStr);
		}
	}
}
