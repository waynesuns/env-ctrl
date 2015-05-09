package com.waynesun.utils.convert.pdf;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

public class MSOPptPdfConverter extends MSOfficePdfConverter {

	@Override
	protected String getAPPName() {
		return "PowerPoint.Application";
	}

	@Override
	protected Dispatch getContent(ActiveXComponent app, String filePath) {
        Dispatch ppts = app.getProperty("Presentations").toDispatch();  
        
        // 因POWER.EXE的发布规则为同步，所以设置为同步发布  
        Dispatch ppt = Dispatch.call(ppts, "Open", filePath, true,// ReadOnly  
                true,// Untitled指定文件是否有标题  
                false// WithWindow指定文件是否可见  
                ).toDispatch();  
        return ppt;
	}

	@Override
	protected void saveFile(Dispatch content, String pdfFilePath) {
        Dispatch.call(content, "SaveAs", pdfFilePath, 32); //ppSaveAsPDF为特定值32  
	}

}
