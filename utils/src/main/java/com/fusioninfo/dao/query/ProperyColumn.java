package com.fusioninfo.dao.query;

import com.fusioninfo.dao.query.condition.ColumnEntry;
import com.fusioninfo.dao.query.condition.ColumnPropertyEntry;

public class ProperyColumn extends Column implements IPropertyColumn {

	@Override
	public boolean isFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QueryFunction getFunction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColumnEntry getColumnEntry() {
		// TODO Auto-generated method stub
		return ColumnPropertyEntry.newInstance(getPropertyName(), getAlias());
	}
	
}
