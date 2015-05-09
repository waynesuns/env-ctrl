package com.fusioninfo.utils.file.media;

import com.fusioninfo.utils.file.preview.PreviewGeneratorOwner;

public class Image extends AbstractMedia {
	private static final long serialVersionUID = -2090944516724006109L;
	
	@Override
	public String getPreviewFilePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends PreviewGeneratorOwner> getPreviewGeneratorOwnerKey() {
		return Image.class;
	}

}
