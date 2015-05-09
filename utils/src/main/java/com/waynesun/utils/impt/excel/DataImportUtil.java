package com.waynesun.utils.impt.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.waynesun.exception.BizException;
import com.waynesun.utils.impt.param.excel.ExcelImportParamter;

public class DataImportUtil {

	/**
	 * excel导入
	 * @param <T>
	 * @param clazz
	 * @param params
	 * @param file
	 * @param sheetIdex
	 * @return
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
	public static <T> List<T> doExcelImport(Class<T> clazz,List<? extends ExcelImportParamter> params,MultipartFile file,int sheetIdex) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return DataImportUtil.doExcelImport(clazz, params, DataImportUtil.getWorkbook(file), sheetIdex);
	}
	
	/**
	 * excel导入
	 * @param <T>
	 * @param clazz
	 * @param params
	 * @param file
	 * @param sheetIdex
	 * @return
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
	public static <T> List<T> doExcelImport(Class<T> clazz,List<? extends ExcelImportParamter> params,File file,int sheetIdex) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return DataImportUtil.doExcelImport(clazz, params, DataImportUtil.getWorkbook(file), sheetIdex);
	}
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
		throw new BizException("common.excel.validate");
	}
	
	/**
	 * excel导入（不支持2007）
	 * @param <T>
	 * @param clazz
	 * @param params
	 * @param inputStream
	 * @param sheetIdex
	 * @return
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
	@Deprecated
	public static <T> List<T> doExcelImport(Class<T> clazz,List<? extends ExcelImportParamter> params,InputStream inputStream,int sheetIdex) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return DataImportUtil.doExcelImport(clazz, params, new XSSFWorkbook(inputStream), sheetIdex);
	}
	/**
	 * excel导入
	 * @param <T>
	 * @param clazz
	 * @param params
	 * @param data
	 * @param sheetIdex
	 * @return
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
	public static <T> List<T> doExcelImport(Class<T> clazz,List<? extends ExcelImportParamter> params,Workbook data,int sheetIdex) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		Sheet sheet = data.getSheetAt(sheetIdex);
		Iterator<Row> i = sheet.rowIterator();
		List<T> list = new ArrayList<T>();
		
		if(i.hasNext()){
			//首行为标题，跳过
			i.next();
		}
		while(i.hasNext()){
			Row row = i.next();
			T entity = clazz.newInstance(); 
			for(ExcelImportParamter param : params){
				
				param.setValue(entity, row);
			}
			list.add(entity);
		}
		return list;
	}
	
	/**
	 * excel导入
	 * @param <T>
	 * @param clazz
	 * @param params
	 * @param file
	 * @param sheetIdex
	 * @return
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
	public static <T> ExcelImportResult<T> doExcelImport(Class<T> clazz,List<? extends ExcelImportParamter> params,MultipartFile file,int sheetIdex,boolean isThrowException) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return DataImportUtil.doExcelImport(clazz, params, DataImportUtil.getWorkbook(file), sheetIdex,isThrowException);
	}
	public static <T> ExcelImportResult<T> doExcelImport(Class<T> clazz,List<? extends ExcelImportParamter> params,Workbook data,int sheetIdex,boolean isThrowException) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return DataImportUtil.doExcelImport(clazz, params, data, sheetIdex,isThrowException,1);
	}
	public static <T> ExcelImportResult<T> doExcelImport(Class<T> clazz,List<? extends ExcelImportParamter> params,MultipartFile file,int sheetIdex,boolean isThrowException,int skipRowAmt) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return DataImportUtil.doExcelImport(clazz, params, DataImportUtil.getWorkbook(file), sheetIdex,isThrowException,skipRowAmt);
	}
	public static <T> ExcelImportResult<T> doExcelImport(Class<T> clazz,List<? extends ExcelImportParamter> params,Workbook data,int sheetIdex,boolean isThrowException,int skipRowAmt) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		Sheet sheet = data.getSheetAt(sheetIdex);
		Iterator<Row> i = sheet.rowIterator();
		List<T> datas = new ArrayList<T>();
		List<String> errors = new ArrayList<String>();
		
		ExcelImportResult<T> result = new ExcelImportResult<T>();
		for(int j=0;i.hasNext()&&j<skipRowAmt;j++){
			
			//首行为标题，跳过
			i.next();
		}
		while(i.hasNext()){
			Row row = i.next();
			T entity = clazz.newInstance(); 
			for(ExcelImportParamter param : params){
				if(isThrowException){
					param.setValue(entity, row);
				}else{
					try {
						param.setValue(entity, row);
					} catch (BizException e) {
						errors.add(e.getMessage());
						break;
					}catch(RuntimeException e){
						if(e.getCause() instanceof BizException){
						errors.add(e.getCause().getMessage());
						break;
						}else{
							throw e;
						}
					}
				}
			}
			datas.add(entity);
		}
		result.setDatas(datas);
		result.setErrors(errors);
		return result;
	}
}
