package com.fusioninfo.utils.search;

import java.io.File;

public interface SearchableFile extends SearchableObject{
	public File getIndexFile();
	public boolean isIndexFile();
}
