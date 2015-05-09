package com.waynesun.utils.convert.swf;

import java.io.IOException;

public interface SwfConverter {
	public boolean toSwf(String swfToolsPath,String filePath, String swfFilePath) throws IOException;
}