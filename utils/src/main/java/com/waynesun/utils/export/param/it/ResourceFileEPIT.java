package com.waynesun.utils.export.param.it;

import com.waynesun.utils.MessageReader;
import com.waynesun.utils.export.param.ExportParamInterType;
/**
 * 通过资源文件进行国际化
 * @author wayne
 *
 */
public class ResourceFileEPIT implements ExportParamInterType{
	/**资源文件KEY前缀，例：当"status_"为资源文件KEY前缀，1为value获取到的值，则对应的资源文件key为"status_1"*/
	private String interKey;
	public ResourceFileEPIT(String interKey){
		this.interKey = interKey;
	}
	@Override
	public Object getValue(Object key) {
		return MessageReader.getMessage(interKey + key.toString(), null);
	}

}
