package com.waynesun.utils.convert.pdf;

import java.util.Map;

import com.waynesun.utils.file.document.AbstractDocument;

public abstract class AbstractDocumentPdfConverter implements PdfConverter{

	private static final Map<Class<? extends AbstractDocument>,MSOfficePdfConverter> DOCUMENT_CONVERTER_MAP = new java.util.HashMap<Class<? extends AbstractDocument>, MSOfficePdfConverter>();

	public static MSOfficePdfConverter getInstance(AbstractDocument document){
		return AbstractDocumentPdfConverter.DOCUMENT_CONVERTER_MAP.get(document.getClass());
	}
	
	public static void addMapping(Class<? extends AbstractDocument> docClass,MSOfficePdfConverter converter){
		AbstractDocumentPdfConverter.DOCUMENT_CONVERTER_MAP.put(docClass, converter);
	}

}
