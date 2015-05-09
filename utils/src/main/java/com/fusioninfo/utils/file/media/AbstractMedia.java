package com.fusioninfo.utils.file.media;

import com.fusioninfo.utils.file.AbstractFile;
import com.fusioninfo.utils.file.preview.PreviewGeneratorOwner;

public abstract class AbstractMedia extends AbstractFile {
	private static final long serialVersionUID = -1482135277360656028L;

	@Override
	public boolean generateIndex() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class<? extends PreviewGeneratorOwner> getPreviewGeneratorOwnerKey() {
		return AbstractMedia.class;
	}
}
