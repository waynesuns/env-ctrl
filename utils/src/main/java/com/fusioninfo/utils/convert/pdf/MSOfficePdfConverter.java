package com.fusioninfo.utils.convert.pdf;

import com.fusioninfo.utils.file.document.AbstractDocument;
import com.fusioninfo.utils.file.document.Doc;
import com.fusioninfo.utils.file.document.Ppt;
import com.fusioninfo.utils.file.document.Xls;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public abstract class MSOfficePdfConverter extends AbstractDocumentPdfConverter {

	static{
		AbstractDocumentPdfConverter.addMapping(Doc.class, new MSOXlsPdfConverter());
		AbstractDocumentPdfConverter.addMapping(Ppt.class, new MSOPptPdfConverter());
		AbstractDocumentPdfConverter.addMapping(Xls.class, new MSODocPdfConverter());
	}
	protected abstract void saveFile(Dispatch content,String pdfFilePath);
	@Override
	public boolean toPdf(AbstractDocument document,String officeFilePath,String pdfFilePath) {
		ComThread.InitSTA();
		//打开excel应用程序
		ActiveXComponent app = new ActiveXComponent(this.getAPPName());
		Dispatch content = null;
		try{
			app.setProperty("Visible", new Variant(false));
			content = this.getContent(app, officeFilePath);
			this.setParams(content);
		}finally{
			if(content!=null){
				Dispatch.call(content, "Close", new Variant(false));
			}
			if (app != null){
				app.invoke("Quit", new Variant[]{});
			}
			ComThread.Release();
		}
		return true;
	}

	protected abstract String getAPPName();
	
	protected abstract Dispatch getContent(ActiveXComponent app,String filePath);
	
	protected void setParams(Dispatch content){
		
	} 
	
}
