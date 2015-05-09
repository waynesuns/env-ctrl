package com.waynesun.utils.file.document;

import com.waynesun.utils.file.AbstractFile;
import com.waynesun.utils.file.preview.PreviewGeneratorOwner;

public abstract class AbstractDocument extends AbstractFile {
	private static final long serialVersionUID = -180973431476968982L;

	@Override
	public String getPreviewFilePath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean generateIndex(){
		return true;
	}

	@Override
	public Class<? extends PreviewGeneratorOwner> getPreviewGeneratorOwnerKey() {
		return AbstractDocument.class;
	}
}
