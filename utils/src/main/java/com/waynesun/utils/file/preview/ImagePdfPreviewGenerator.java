package com.waynesun.utils.file.preview;

import java.io.IOException;

import com.waynesun.utils.file.AbstractFile;

public class ImagePdfPreviewGenerator extends AbstractDocumentPreviewGenerator {

	private String watermark;
	
	public ImagePdfPreviewGenerator(String watermark){
		this.watermark = watermark;
	}
	
	@Override
	public boolean generatePreviewFile(AbstractFile file) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getFileSuffix() {
		// TODO Auto-generated method stub
		return "jpeg";
	}

	public String getWatermark() {
		return watermark;
	}

	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

}
