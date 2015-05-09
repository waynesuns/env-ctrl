package com.fusioninfo.utils.file.binary;

import com.fusioninfo.utils.file.AbstractFile;
import com.fusioninfo.utils.file.preview.PreviewGeneratorOwner;

public abstract class AbstractBinaryFile extends AbstractFile {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6143420071206418131L;
	
	@Override
	public boolean generateIndex(){
		return true;
	}

	@Override
	public Class<? extends PreviewGeneratorOwner> getPreviewGeneratorOwnerKey() {
		return AbstractBinaryFile.class;
	}
}
