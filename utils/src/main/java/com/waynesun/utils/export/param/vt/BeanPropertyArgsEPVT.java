package com.waynesun.utils.export.param.vt;

import com.waynesun.utils.BeanUtil;
import com.waynesun.utils.export.param.ExportParamValueType;

/**
 * @ClassName: BeanPropertyArgsEPVT
 * @Description: 通过类的GET方法获取返回值,可以传参
 * @author zhengnan
 * @date 2013-1-9 下午02:02:56
 *
 */
public class BeanPropertyArgsEPVT implements ExportParamValueType {
	private String propertyName;
	private Object[] args;

	public BeanPropertyArgsEPVT(String propertyName, Object[] args) {
		this.propertyName = propertyName;
		this.args = args;
	}

	@Override
	public Object getValue(Object object)throws Exception {
		return BeanUtil.invokGetMethodChain(object, propertyName, ".", args, null);
	}
}