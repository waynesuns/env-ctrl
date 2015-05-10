package com.waynesun.common.util.datatable;

import com.waynesun.pojo.Pages;

public class DataTablePages extends Pages
{
	private Integer iDisplayStart;
	private Integer iDisplayLength;
	private Integer iColumns;
	private String sSearch;
	private Boolean bRegex;
	private Boolean bSearchable_;
	private String sSearch_;
	private Boolean bRegex_;
	private Boolean bSortable_;
	private Integer iSortingCols;
	private Integer iSortCol_;
	private String sSortDir_;
	private String mDataProp_;
	private String sEcho;
	
	public DataTablePages(){
		super.setPageSize(20);
	}

	@Override
	public int getCurrentPage()
	{
		if(this.getiDisplayStart() == null || this.getiDisplayLength() == null)
			return 1;
		return this.getiDisplayStart() == 1 ? 1 : (this.getiDisplayStart() / this.getiDisplayLength()) + 1;
	}

	@Override
	public int getPageSize()
	{
		if(this.getiDisplayLength() == null)
			return super.getPageSize();
		return this.getiDisplayLength();
	}

	public int getCurrentPageByDataTable()
	{
		if(this.getiDisplayStart() == null || this.getiDisplayLength() == null)
			return 1;
		return this.getiDisplayStart() == 1 ? 1 : (this.getiDisplayStart() / this.getiDisplayLength()) + 1;
	}

	public Integer getiDisplayStart()
	{
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart)
	{
		this.iDisplayStart = iDisplayStart;
	}

	public Integer getiDisplayLength()
	{
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength)
	{
		this.iDisplayLength = iDisplayLength;
	}

	public Integer getiColumns()
	{
		return iColumns;
	}

	public void setiColumns(Integer iColumns)
	{
		this.iColumns = iColumns;
	}

	public String getsSearch()
	{
		return sSearch;
	}

	public void setsSearch(String sSearch)
	{
		this.sSearch = sSearch;
	}

	public Boolean getbRegex()
	{
		return bRegex;
	}

	public void setbRegex(Boolean bRegex)
	{
		this.bRegex = bRegex;
	}

	public Boolean getbSearchable_()
	{
		return bSearchable_;
	}

	public void setbSearchable_(Boolean bSearchable_)
	{
		this.bSearchable_ = bSearchable_;
	}

	public String getsSearch_()
	{
		return sSearch_;
	}

	public void setsSearch_(String sSearch_)
	{
		this.sSearch_ = sSearch_;
	}

	public Boolean getbRegex_()
	{
		return bRegex_;
	}

	public void setbRegex_(Boolean bRegex_)
	{
		this.bRegex_ = bRegex_;
	}

	public Boolean getbSortable_()
	{
		return bSortable_;
	}

	public void setbSortable_(Boolean bSortable_)
	{
		this.bSortable_ = bSortable_;
	}

	public Integer getiSortingCols()
	{
		return iSortingCols;
	}

	public void setiSortingCols(Integer iSortingCols)
	{
		this.iSortingCols = iSortingCols;
	}

	public Integer getiSortCol_()
	{
		return iSortCol_;
	}

	public void setiSortCol_(Integer iSortCol_)
	{
		this.iSortCol_ = iSortCol_;
	}

	public String getsSortDir_()
	{
		return sSortDir_;
	}

	public void setsSortDir_(String sSortDir_)
	{
		this.sSortDir_ = sSortDir_;
	}

	public String getmDataProp_()
	{
		return mDataProp_;
	}

	public void setmDataProp_(String mDataProp_)
	{
		this.mDataProp_ = mDataProp_;
	}

	public String getsEcho()
	{
		return sEcho;
	}

	public void setsEcho(String sEcho)
	{
		this.sEcho = sEcho;
	}
}
