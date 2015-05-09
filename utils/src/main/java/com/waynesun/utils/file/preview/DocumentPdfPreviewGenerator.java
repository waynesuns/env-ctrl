package com.waynesun.utils.file.preview;

import java.io.IOException;

import com.waynesun.exception.BizException;
import com.waynesun.utils.convert.pdf.AbstractDocumentPdfConverter;
import com.waynesun.utils.convert.pdf.PdfConverter;
import com.waynesun.utils.file.AbstractFile;
import com.waynesun.utils.file.document.AbstractDocument;

public class DocumentPdfPreviewGenerator extends AbstractDocumentPreviewGenerator {
	private boolean isReadOnly = false;
	private boolean isCopyable = true;
	private String watermark;
	
	public DocumentPdfPreviewGenerator(boolean isReadOnly,boolean isCopyable,String watermark){
		this.isCopyable = isCopyable;
		this.isReadOnly = isReadOnly;
		this.watermark = watermark;
	}
	
	@Override
	public boolean generatePreviewFile(AbstractFile file) throws IOException {
		if(file instanceof AbstractDocument){
			PdfConverter converter = AbstractDocumentPdfConverter.getInstance((AbstractDocument)file);
			if(converter == null){
				throw new BizException("converter file type");
			}
			converter.toPdf((AbstractDocument)file, file.getFilePath()+"/"+file.getFileName(), this.getDownlodFilePath(file));
		}else{
			throw new BizException("invalid file type");
		}
		
		return true;
	}

	@Override
	protected String getFileSuffix() {
		return "pdf";
	}

	public boolean isReadOnly() {
		return isReadOnly;
	}

	public void setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	public boolean isCopyable() {
		return isCopyable;
	}

	public void setCopyable(boolean isCopyable) {
		this.isCopyable = isCopyable;
	}

	public String getWatermark() {
		return watermark;
	}

	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	
}
