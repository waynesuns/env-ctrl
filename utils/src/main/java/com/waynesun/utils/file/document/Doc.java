package com.waynesun.utils.file.document;

import java.io.IOException;

import com.waynesun.utils.convert.pdf.AbstractDocumentPdfConverter;
import com.waynesun.utils.convert.pdf.MSODocPdfConverter;
import com.waynesun.utils.file.AbstractFile;
import com.waynesun.utils.file.preview.AbstractPreviewGenerator;
import com.waynesun.utils.file.preview.DocumentPdfPreviewGenerator;

public class Doc extends AbstractDocument{
	private static final long serialVersionUID = 8363213044708885160L;
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
		AbstractDocument.addMapping("docx", Doc.class);
		AbstractPreviewGenerator.addMapping(Doc.class, new DocumentPdfPreviewGenerator(true,true,null));
		AbstractDocumentPdfConverter.addMapping(Doc.class, new MSODocPdfConverter());
		AbstractFile doc = AbstractDocument.generateInstance("Doc1.docx", "/Users/weisun/software/windows");
		doc.generatePreviewFile();
	}

}
