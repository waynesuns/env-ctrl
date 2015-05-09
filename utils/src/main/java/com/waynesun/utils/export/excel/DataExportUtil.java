package com.waynesun.utils.export.excel;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.waynesun.pojo.BasePojo;
import com.waynesun.utils.StringUtils;
import com.waynesun.utils.excel.ExcelUtil;
import com.waynesun.utils.export.param.excel.ExcelExportParam;

/**
 * 数据导出工具类
 * @author weis
 *
 */
public class DataExportUtil {

	public static final ThreadLocal<HSSFCellStyle> TITLE_STYLE = new ThreadLocal<HSSFCellStyle>();
	public static final ThreadLocal<HSSFCellStyle> CELL_STYLE = new ThreadLocal<HSSFCellStyle>();
	public static final ThreadLocal<HSSFCellStyle> DATE_CELL_STYLE = new ThreadLocal<HSSFCellStyle>();
	public static HSSFWorkbook generateExcelFile(){
		return new HSSFWorkbook();
	}
	
	/**
	 * 生成poi的excel对象并将值导入其中
	 * @param exportParams 导出参数
	 * @param datas 待转换数据
	 * @return HSSFWorkbook poi的excel对象
	 * @throws Exception 
	 */
	public static HSSFWorkbook generateExcelFile(List<ExcelExportParam> exportParams,List<? extends BasePojo> datas) throws Exception{
		return DataExportUtil.generateExcelFile(exportParams, datas, 0);
	}

	/**
	 * 将值导入传入的poi的excel对象中
	 * @param workbook
	 * @param exportParams 导出参数
	 * @param datas 待转换数据
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook generateExcelFile(HSSFWorkbook workbook,List<ExcelExportParam> exportParams,List<? extends BasePojo> datas) throws Exception{
		return DataExportUtil.generateExcelFile(workbook,exportParams, datas, 0,null);
	}
	/**
	 * 生成poi的excel对象并将值导入其中
	 * @param exportParams 导出参数
	 * @param datas 待填充数据
	 * @param startRowIndex 开始行的INDEX
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook generateExcelFile(List<ExcelExportParam> exportParams,List<? extends BasePojo> datas,int startRowIndex) throws Exception{
		return DataExportUtil.generateExcelFile(new HSSFWorkbook(),exportParams, datas, startRowIndex,null);
	}
	
	/**
	 * 将值导入传入的poi的excel对象中
	 * @param workbook
	 * @param exportParams 导出参数
	 * @param datas 待填充数据
	 * @param startRowIndex 开始行的INDEX
	 * @param title 标题
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook generateExcelFile(HSSFWorkbook workbook,List<ExcelExportParam> exportParams,List<? extends BasePojo> datas,int startRowIndex,BasePojo title) throws Exception{
		Map<Integer,ExcelExportParam> propRefs = new TreeMap<Integer,ExcelExportParam>();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row=sheet.createRow(startRowIndex);
		row.setHeight((short) 500);// 设定行的高度
		Iterator<ExcelExportParam> ti = exportParams.iterator();
		for(int i=0;ti.hasNext();i++){
			ExcelExportParam exportParam = (ExcelExportParam)ti.next();
			ExcelUtil.generateCell(workbook,row,new Integer(i),exportParam.getTitle(title),ExcelUtil.getTitleCellStyle(workbook));
			propRefs.put(new Integer(i), exportParam);
			//设置单元格根据title自适应宽度
		    sheet.autoSizeColumn(i, true);
		}

		Iterator<? extends BasePojo> di = datas.iterator();
		for(int i=0;di.hasNext();i++){
			Object data = di.next();
			row = sheet.createRow(i+startRowIndex+1);
			row.setHeight((short) 500);// 设定行的高度
			Iterator<Integer> ki = propRefs.keySet().iterator();
			while(ki.hasNext()){
				Integer key = (Integer)ki.next();
				ExcelExportParam exportParam = (ExcelExportParam)propRefs.get(key);
				ExcelUtil.generateCell(workbook,row,key,exportParam.getValue(data),exportParam.getStyle());
			}
		}
		
		DataExportUtil.resetCellStyle();
		return workbook;
	}
	/**
	 * 重置当前线程中的单元格样式
	 */
	public static void resetCellStyle(){
		DataExportUtil.TITLE_STYLE.remove();
		DataExportUtil.CELL_STYLE.remove();
		DataExportUtil.DATE_CELL_STYLE.remove();
	}
	/**
	 * 将excel文件写入response输入流
	 * @param wb
	 * @param fileName
	 * @param response
	 * @throws IOException
	 */
	public static void exportExceltoclient(HSSFWorkbook wb,String fileName,HttpServletResponse response,HttpServletRequest... httpServletRequests ) throws IOException{
		if(httpServletRequests==null||httpServletRequests.length==0){
			fileName=StringUtils.toUtf8String(fileName);
		}else{
			HttpServletRequest req=httpServletRequests[0];
			String agent=req.getHeader("user-agent");
			if(agent.indexOf("MSIE 6.0")>0){//处理IE6
				fileName=URLEncoder.encode(fileName);
			}else{
				fileName=StringUtils.toUtf8String(fileName);
			}
		}
		response.setContentType("application/msexcel;charset=utf-8");
		response.addHeader("Content-Disposition", "attachment;filename=\"" + fileName+"\"");
		BufferedOutputStream out=new BufferedOutputStream(response.getOutputStream());
		wb.write(out);   
		out.flush();  
		out.close();
		DataExportUtil.resetCellStyle();
	}
}
