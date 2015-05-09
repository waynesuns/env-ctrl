package com.waynesun.utils.convert.pdf;

import com.waynesun.utils.file.document.AbstractDocument;

public interface PdfConverter {
	public boolean toPdf(AbstractDocument document,String officeFilePath,String pdfFilePath);
}
