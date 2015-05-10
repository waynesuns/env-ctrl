package com.waynesun.common.biz.dictionary;

import java.util.List;
import java.util.Set;

import com.waynesun.exception.BizException;

public class DictionaryCategory extends Dictionary
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2421877586886053432L;

	private Set<DictionaryItem> dictionaryItems;
	
	/**
	 * 验证编号是否重复，重复抛出异常
	 * 
	 */
	@Override
	public void validateRepeat()
	{
		DictionaryQC qc = new DictionaryQC();
		qc.setCode(getCode());
		List<Dictionary> list = DictionaryUtils.findDictionary(qc);
		if (list != null && list.size() > 0)
			throw new BizException("dictionary.code.repeat");
	}

	public String getStateStr()
	{
		return "";
	}

	public Set<DictionaryItem> getDictionaryItems()
	{
		return dictionaryItems;
	}

	public void setDictionaryItems(Set<DictionaryItem> dictionaryItems)
	{
		this.dictionaryItems = dictionaryItems;
	}

	@Override
	public int getDiscriminator()
	{
		return 0;
	}
}
