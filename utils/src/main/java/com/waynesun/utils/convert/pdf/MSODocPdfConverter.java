package com.waynesun.utils.convert.pdf;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class MSODocPdfConverter extends MSOfficePdfConverter {

	@Override
	protected String getAPPName() {
		return "Word.Application";
	}

	@Override
	protected Dispatch getContent(ActiveXComponent app, String filePath) { 
		Dispatch docs = app.getProperty("Documents").toDispatch();  
		Dispatch doc = Dispatch.invoke(docs, "Open", Dispatch.Method,  
            new Object[] { filePath,   
                                         new Variant(false),   
                                         new Variant(true),//是否只读  
                                         new Variant(false),   
                                         new Variant("pwd") },  
            new int[1]).toDispatch();  
		return doc;
	}
	
	@Override
	protected void setParams(Dispatch content) {
//		Dispatch.put(content, "Compatibility", false);  //兼容性检查,为特定值false不正确  
        Dispatch.put(content, "RemovePersonalInformation", false);  
	}
	
	@Override
	protected void saveFile(Dispatch content, String pdfFilePath) {
        Dispatch.call(content, "ExportAsFixedFormat", pdfFilePath, 17); // word保存为pdf格式宏，值为17  
	}

}
