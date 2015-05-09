package com.fusioninfo.dao.query.condition;

import com.fusioninfo.dao.query.IColumn;


public abstract class ColumnGroupEntry extends ColumnEntry {
	protected ColumnGroupEntry(String propertyName,String alias) {
		// TODO Auto-generated constructor stub
		super(propertyName,alias);
	}
	@Override
	public boolean isGroup() {
		// TODO Auto-generated method stub
		return true;
	}
	public static ColumnEntry newInstance(IColumn column){
		if(!column.isFunction())
			return ColumnGroupPropertyEntry.newInstance(column.getPropertyName(), column.getAlias());
		return null;
	}
}
