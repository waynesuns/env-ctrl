package com.waynesun.utils.file.preview;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPreviewGenerator implements PreviewFileGenerator{

	private static final Map<Class<? extends PreviewGeneratorOwner>,PreviewFileGenerator> PREVIEW_FILE_GENERATOR_MAP = new HashMap<Class<? extends PreviewGeneratorOwner>, PreviewFileGenerator>();

	public static PreviewFileGenerator getInstance(PreviewGeneratorOwner owner){
		PreviewFileGenerator generator = AbstractPreviewGenerator.PREVIEW_FILE_GENERATOR_MAP.get(owner.getClass());
		if(generator==null)
			generator = EmptyPreviewGenerator.getInstance();
		return generator;
	}
	
	public static void addMapping(Class<? extends PreviewGeneratorOwner> ownerClass,PreviewFileGenerator generator){
		AbstractPreviewGenerator.PREVIEW_FILE_GENERATOR_MAP.put(ownerClass, generator);
	}
}
