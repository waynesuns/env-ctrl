package com.waynesun.common.util.init.data.impl;

import java.util.List;

import com.waynesun.common.biz.announcement.AnnouncementFeedback;
import com.waynesun.common.biz.area.AbstractArea;
import com.waynesun.common.biz.config.SystemConfig;
import com.waynesun.common.biz.dealerarea.AbstractDealerArea;
import com.waynesun.common.biz.dictionary.DictionaryCategory;
import com.waynesun.common.biz.dictionary.DictionaryItem;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.biz.veh.VehicleBrand;
import com.waynesun.common.util.init.data.Data;
import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;

public class DataImpl implements Data {

	@Override
	public List<AbstractDealer> findAllDealers() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(AbstractDealer.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<AbstractArea> findAllAreas() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(AbstractArea.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<SystemConfig> findAllSystemConfigs() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(SystemConfig.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<Resource> findAllResources() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(Resource.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<Role> findAllRoles() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(Role.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<DictionaryItem> findAllDictionaryItems() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(DictionaryItem.class, null, new SimpleQuery(), false).getResults();
	}

	@Override
	public List<DictionaryCategory> findAllDictionaryCategories() {
		// TODO Auto-generated method stub
		return DaoFactory.getInstance().getQueryDao().list(DictionaryCategory.class, null, new SimpleQuery(), false).getResults();
	}
}
