package com.fusioninfo.utils.file.preview;

import java.io.IOException;

import com.fusioninfo.utils.file.AbstractFile;

public interface PreviewFileGenerator {
	public boolean generatePreviewFile(AbstractFile file) throws IOException;
	
	public String getDownlodFilePath(AbstractFile file);
	
	public String getPreviewFilePath(AbstractFile file); 
}
