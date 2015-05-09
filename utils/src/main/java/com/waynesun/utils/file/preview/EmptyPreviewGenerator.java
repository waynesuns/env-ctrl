package com.waynesun.utils.file.preview;

import java.io.IOException;

import com.waynesun.utils.file.AbstractFile;

public class EmptyPreviewGenerator extends AbstractPreviewGenerator{
	private static final EmptyPreviewGenerator INSTANCE = new EmptyPreviewGenerator();
	
	public static EmptyPreviewGenerator getInstance(){
		return EmptyPreviewGenerator.INSTANCE;
	}
	
	@Override
	public boolean generatePreviewFile(AbstractFile file) throws IOException {
		return true;
	}

	@Override
	public String getDownlodFilePath(AbstractFile file) {
		return file.getFilePath()+"/"+file.getUuid()+"."+file.getFileSuffix();
	}

	@Override
	public String getPreviewFilePath(AbstractFile file) {
		return null;
	}

}
