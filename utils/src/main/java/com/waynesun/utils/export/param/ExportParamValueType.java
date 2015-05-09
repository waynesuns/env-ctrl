package com.waynesun.utils.export.param;


/**
 * 值类型
 * @author wayne
 *
 */
public interface ExportParamValueType {
	public abstract Object getValue(Object object) throws Exception;
}
