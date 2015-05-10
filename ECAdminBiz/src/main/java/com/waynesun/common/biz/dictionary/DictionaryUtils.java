package com.waynesun.common.biz.dictionary;

import java.util.List;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;

/**
 * @ClassName: DictionaryUtils
 * @Description: Dictionary工具
 *
 */
public class DictionaryUtils {

	public static List<DictionaryItem> findAllDictionaryItems() {
		return DaoFactory.getInstance().getQueryDao().list(DictionaryItem.class, null, new SimpleQuery(), true).getResults();
	}

	public static List<DictionaryCategory> findAllDictionaryCategories() {
		return DaoFactory.getInstance().getQueryDao().list(DictionaryCategory.class, null, new SimpleQuery(), true).getResults();
	}

	public static List<Dictionary> findDictionary(DictionaryQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(Dictionary.class, null, sq, true).getResults();
	}

	public static List<DictionaryCategory> findDictionaryCategories(DictionaryQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(DictionaryCategory.class, null, sq, true).getResults();
	}

	public static DictionaryCategory findDictionaryCategory(String id) {
		return DaoFactory.getInstance().getQueryDao().get(DictionaryCategory.class, id, true);
	}
}