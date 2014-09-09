package com.ec.website.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.ec.website.param.TableHeaderParam;
import com.ec.website.param.TableTdParam;
import com.ec.website.param.group.TableGroupParam;


public class DataImportUtil {

	/**
	 * 生成POI excel对象
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static Workbook getWorkbook(MultipartFile file) throws IOException{
		return DataImportUtil.getWorkbook(file.getOriginalFilename(),file.getInputStream());
	}
	
	/**
	 * 生成POI excel对象
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static Workbook getWorkbook(File file) throws IOException{
		return DataImportUtil.getWorkbook(file.getName(),new FileInputStream(file));
	}
	

	/**
	 * 生成POI excel对象
	 * @param fileName
	 * @param is
	 * @return
	 * @throws IOException
	 */
	private static Workbook getWorkbook(String fileName,InputStream is) throws IOException{
		String[] fileNameArray = fileName.split("\\.");
		if(fileNameArray.length>1){
			String fix = fileNameArray[fileNameArray.length-1].trim().toLowerCase();
			if("xls".equals(fix.trim().toLowerCase())){
				return new HSSFWorkbook(is);
			}else if("xlsx".equals(fix.trim().toLowerCase())){
				return new XSSFWorkbook(is);
			}
		}
		return null;
	}
	
	private static TableTdParam setMergedRegion(Sheet sheet,int row ,int column,TableTdParam td) {  
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if (firstRow!=lastRow && row<=lastRow && row >= firstRow) {
				if (column >= firstColumn && column<=lastColumn) {
					if(row == firstRow){
						td.setRowSpan(lastRow-firstRow+1);
						return td;
					}else{
						return null;
					}
					
				}else{
					return td;
				}
			}
		}
		return td;
	}

	public static TableGroupParam doExcelImport(int sheetIdex,File file,String title,String[] width) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		TableGroupParam tableGroupParam = new TableGroupParam(title);
		FileInputStream io = new FileInputStream(file);
		Workbook data = DataImportUtil.getWorkbook(file.getName(),io);
		Sheet sheet = data.getSheetAt(sheetIdex);
		Iterator<Row> i = sheet.rowIterator();
		Row header = i.next();
		Iterator<Cell> headerCells= header.cellIterator();
		int index = 0;
		while(headerCells.hasNext()){
			tableGroupParam.addHeader(new TableHeaderParam(headerCells.next().getStringCellValue(),width!=null?width[index]:""));
			index++;
		}
		List<TableTdParam> tableCells;
		while(i.hasNext()){
			Row row = i.next();
			tableCells = new ArrayList<TableTdParam>();
			Iterator<Cell> cells= row.cellIterator();
			while(cells.hasNext()){
				Cell cell = cells.next();
				TableTdParam td  = DataImportUtil.setMergedRegion(sheet, row.getRowNum(), cell.getColumnIndex(), new TableTdParam(cell.getStringCellValue()));
				if(td!=null)
						tableCells.add(td);
			}
			tableGroupParam.addValue(tableCells);
		}
		io.close();
		return tableGroupParam;
	}
}
