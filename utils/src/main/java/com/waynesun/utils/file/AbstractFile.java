package com.waynesun.utils.file;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.waynesun.exception.BizException;
import com.waynesun.pojo.BaseEntity;
import com.waynesun.utils.file.icon.FileIcon;
import com.waynesun.utils.file.preview.AbstractPreviewGenerator;
import com.waynesun.utils.file.preview.PreviewFileGenerator;
import com.waynesun.utils.file.preview.PreviewGeneratorOwner;

/**
 * 
 * 文件抽象类
 * @author weisun
 *
 */
public abstract class AbstractFile extends BaseEntity implements PreviewGeneratorOwner{
	private static final long serialVersionUID = -7149069595676435230L;
	/**文件名*/
	private String fileName;
	/**文件路径*/
	private String filePath;
	/**文件后缀名*/
	private String fileSuffix;
	/**UUID*/
	private String uuid;
	/**文件所有者*/
	private FileOwner owner;
		
	private static final Map<String,Class<? extends AbstractFile>> FILE_SUFFIX_MAP = new HashMap<String,Class<? extends AbstractFile>>();

	public static AbstractFile generateInstance(String fileName,String filePath) throws InstantiationException, IllegalAccessException{
		if(StringUtils.isEmpty(fileName))
			throw new BizException("fileName is empty");
		int index = fileName.lastIndexOf(".");
		if(index<0)
			throw new BizException("fileName is invalid");
		
		String suffix = fileName.substring(index+1).toLowerCase();
		Class<? extends AbstractFile> fileClass = FILE_SUFFIX_MAP.get(suffix);
		if(fileClass==null)
			fileClass = UnknownFile.class;
		
		AbstractFile file = fileClass.newInstance();
		file.setFileName(fileName);
		file.setFilePath(filePath);
		file.setFileSuffix(suffix);
		file.setUuid(UUID.randomUUID().toString());
		
		return file;
	}
	
	public static void addMapping(String fileSuffix,Class<? extends AbstractFile> fileClass){
		AbstractFile.FILE_SUFFIX_MAP.put(fileSuffix, fileClass);
	}

	public boolean generatePreviewFile() throws IOException {
		PreviewFileGenerator generator = AbstractPreviewGenerator.getInstance(this);
		return generator.generatePreviewFile(this);
	}

	
	public abstract boolean generateIndex();
	
	public boolean doProcess(){
		return false;
	}
	
	public FileIcon getFileIcon(){
		return null;
	}
	
	public String getPreviewFilePath(){
		return this.getPreviewFileGenerator().getPreviewFilePath(this);
	}
	public String getPreviewFileDownloadPath(){
		return this.getPreviewFileGenerator().getDownlodFilePath(this);
	}
	public String getDownLoadPaht(){
		return this.getFilePath()+"/"+this.getUuid()+"."+this.getFileSuffix();
	}

	protected PreviewFileGenerator getPreviewFileGenerator(){
		return AbstractPreviewGenerator.getInstance(this);
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public FileOwner getOwner() {
		return owner;
	}

	public void setOwner(FileOwner owner) {
		this.owner = owner;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}
	
	
}
