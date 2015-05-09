package com.waynesun.utils.convert.swf;

import java.io.IOException;

public class PdfSwfConverter implements SwfConverter{
	private static final PdfSwfConverter INSTANCE = new PdfSwfConverter();

	private PdfSwfConverter(){
		
	}
	public static PdfSwfConverter getInstance(){
		return PdfSwfConverter.INSTANCE;
	}
	@Override
	public boolean toSwf(String swfToolsPath,String pdfFilePath,String swfFilePath) throws IOException {
		Runtime r = Runtime.getRuntime();  
        r.exec(swfToolsPath+"/pdf2swf.exe "+ pdfFilePath + " -o "+ swfFilePath + " -T 9");  
        return true;
	}
}