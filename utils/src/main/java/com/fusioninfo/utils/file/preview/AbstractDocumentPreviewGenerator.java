package com.fusioninfo.utils.file.preview;

import com.fusioninfo.utils.file.AbstractFile;

public abstract class AbstractDocumentPreviewGenerator implements PreviewFileGenerator {

	@Override
	public String getDownlodFilePath(AbstractFile file) {
		return this.getPreviewFilePath(file);
	}

	@Override
	public String getPreviewFilePath(AbstractFile file) {
		return file.getFilePath()+"/"+file.getUuid()+"/"+file.getUuid()+"."+this.getFileSuffix();
	}

	protected abstract String getFileSuffix();
}
