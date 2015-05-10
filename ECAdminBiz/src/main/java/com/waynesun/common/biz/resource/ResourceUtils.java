package com.waynesun.common.biz.resource;

import java.util.Arrays;
import java.util.List;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.order.Order;

/**
 * @ClassName: ResourceUtils
 * @Description: 资源工具
 *
 */
public class ResourceUtils {

	public static List<Menu> findAllMenus() {
		return DaoFactory.getInstance().getQueryDao().list(Menu.class, null, new SimpleQuery(), true).getResults();
	}

	public static List<Resource> findAllResources() {
		return DaoFactory.getInstance().getQueryDao().list(Resource.class, null, new SimpleQuery(), true).getResults();
	}

	public static List<MenuCategory> findAllMenuCategorys() {
		return DaoFactory.getInstance().getQueryDao().list(MenuCategory.class, null, new SimpleQuery(), true).getResults();
	}

	public static List<Button> findAllButtons() {
		return DaoFactory.getInstance().getQueryDao().list(Button.class, null, new SimpleQuery(), true).getResults();
	}

	public static List<Resource> findResources(ResourceQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(Resource.class, null, sq, true).getResults();
	}

	public static List<Resource> findResources(ResourceQC qc, Order[] orders) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(orders));
		return DaoFactory.getInstance().getQueryDao().list(Resource.class, null, sq, true).getResults();
	}

	public static List<Menu> findMenus(ResourceQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(Menu.class, null, sq, true).getResults();
	}

	public static List<Button> findButtons(ButtonQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(Button.class, null, sq, true).getResults();
	}
}