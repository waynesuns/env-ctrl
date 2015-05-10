package com.waynesun.common.biz.dictionary;

import java.util.List;

import com.waynesun.exception.BizException;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.MessageReader;

public class DictionaryItem extends Dictionary
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1554489536059920558L;

	private DictionaryCategory parent;
	
	/**
	 * 验证同一类别下值是否重复，重复抛出异常
	 * 
	 */
	@Override
	public void validateRepeat()
	{
		DictionaryQC qc = new DictionaryQC();
		qc.setParent_code(parent.getCode());
		qc.setParent_id(parent.getId());
		qc.setValue(getValue());
		List<Dictionary> list = DictionaryUtils.findDictionary(qc);
		if (list != null && list.size() > 0)
			throw new BizException("dictionary.value.repeat");
	}
	
	public DictionaryCategory getParent()
	{
		return parent;
	}

	public void setParent(DictionaryCategory parent)
	{
		this.parent = parent;
	}

	@Override
	public int getDiscriminator()
	{
		return 1;
	}
	@Override
	public void update()
	{
		super.update();
		DictionaryCacheUtils.addDictionary(this);
	}
	public String getStateStr()
	{
		if (!PojoState.DELETED.equals(this.getState()))
			return MessageReader.getMessage("state.enabled");
		return MessageReader.getMessage("state.disabled");
	}
}
