package com.waynesun.dao.query.pages;

public interface ResultPages extends IPages {

	public void setTotalRow(int totalRow);

	public int getTotalRow();

	public int getTotalPage();
}