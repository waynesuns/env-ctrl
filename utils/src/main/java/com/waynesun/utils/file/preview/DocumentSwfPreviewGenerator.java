package com.waynesun.utils.file.preview;

import java.io.IOException;

import com.waynesun.utils.convert.swf.PdfSwfConverter;
import com.waynesun.utils.file.AbstractFile;

public class DocumentSwfPreviewGenerator extends DocumentPdfPreviewGenerator {
	private String swfToolsPath = "";
	
	public DocumentSwfPreviewGenerator(boolean isReadOnly,boolean isCopyable,String watermark){
		super(isReadOnly, isCopyable,watermark);
	}
	@Override
	public boolean generatePreviewFile(AbstractFile file) throws IOException {
		super.generatePreviewFile(file);
		PdfSwfConverter.getInstance().toSwf(swfToolsPath, this.getDownlodFilePath(file), file.getPreviewFilePath());
		return true;
	}

	@Override
	public String getDownlodFilePath(AbstractFile file) {
		return super.getDownlodFilePath(file);
	}
	@Override
	protected String getFileSuffix() {
		// TODO Auto-generated method stub
		return "swf";
	}
}
