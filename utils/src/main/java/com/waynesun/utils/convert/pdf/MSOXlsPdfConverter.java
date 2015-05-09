package com.waynesun.utils.convert.pdf;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class MSOXlsPdfConverter extends MSOfficePdfConverter{
	private static final String APP_NAME = "Excel.Application";
	
	
	@Override
	protected String getAPPName() {
		return MSOXlsPdfConverter.APP_NAME;
	}
	
	@Override
	protected void setParams(Dispatch content) {

		Dispatch sheets = Dispatch.get(content, "sheets").toDispatch(); 
		Dispatch sheet = Dispatch.invoke(sheets, "Item",  
		Dispatch.Get, new Object[] { 1 }, new int[1]).toDispatch();  
		Dispatch page = Dispatch.get(sheet, "PageSetup").toDispatch();  
		Dispatch.put(page, "PrintArea", false);  
		Dispatch.put(page, "Orientation", 2);  
		Dispatch.put(page, "Zoom", false);      //值为100或false  
		Dispatch.put(page, "FitToPagesTall", false);  //所有行为一页  
		Dispatch.put(page, "FitToPagesWide", 1);      //所有列为一页(1或false) 
	}


	@Override
	protected Dispatch getContent(ActiveXComponent app, String filePath) {
		Dispatch workbooks = app.getProperty("Workbooks").toDispatch(); //打开具体工作簿  
		Dispatch workbook = Dispatch.invoke(workbooks, "Open", Dispatch.Method,  
		new Object[] {  filePath,
						new Variant(true), // 是否以只读方式打开  
						new Variant(true),  
		 "1",  
		"pwd" },   //输入密码"pwd",若有密码则进行匹配，无则直接打开  
		                         new int[1]).toDispatch();  
		
		return workbook;
	}

	@Override
	protected void saveFile(Dispatch content,String pdfFilePath) {
		Dispatch.invoke(content, 
						"SaveAs", 
						Dispatch.Method, 
						new Object[]{ pdfFilePath, new Variant(57), new Variant(false), new Variant(57), new Variant(57), new Variant(false), new Variant(true), new Variant(57), new Variant(false), new Variant(true), new Variant(false) }, new int[1]);
		         
	}


}
