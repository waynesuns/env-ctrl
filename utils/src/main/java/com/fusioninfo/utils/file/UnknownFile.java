package com.fusioninfo.utils.file;

import com.fusioninfo.utils.file.preview.PreviewGeneratorOwner;

public class UnknownFile extends AbstractFile{
	private static final long serialVersionUID = -5518317165269933561L;

	@Override
	public Class<? extends PreviewGeneratorOwner> getPreviewGeneratorOwnerKey() {
		return UnknownFile.class;
	}

	@Override
	public boolean generateIndex() {
		return true;
	}


}
