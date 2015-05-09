package com.fusioninfo.utils.convert.pdf;

import com.fusioninfo.utils.file.document.AbstractDocument;

public interface PdfConverter {
	public boolean toPdf(AbstractDocument document,String officeFilePath,String pdfFilePath);
}
