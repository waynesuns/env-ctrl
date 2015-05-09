package com.waynesun.pojo;

import com.waynesun.dao.query.pages.QueryPages;
import com.waynesun.dao.query.pages.ResultPages;

public class Pages implements QueryPages, ResultPages
{
	public static final int DEFAULT_PAGE_SIZE = 10;

	private int pageSize = DEFAULT_PAGE_SIZE;

	private int totalRow;

	private int currentPage = 1;

	public Pages(){
		
	}
	public Pages(int currentPage){
		this.currentPage = currentPage;
	}
	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
//		if (currentPage == 0)
//		{
//			setCurrentNumber(0);
//			return;
//		}
		this.currentPage = currentPage;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getTotalRow()
	{
		return totalRow;
	}

	public void setTotalRow(int totalRow)
	{
		this.totalRow = totalRow;
	}


	public int getTotalPage()
	{
		int totalPage = (getTotalRow() - 1) / getPageSize() + 1;

		return totalPage;
	}

	public int getFirstRow()
	{
		return getPageSize() * (getCurrentPage() - 1) + 1;
	}

	public int getLastRow()
	{
		return getPageSize() * getCurrentPage();
	}
	
	public boolean isLast(){
		return this.totalRow<this.getFirstRow();
	}
	
	public boolean next(){
		if(this.isLast()){
			return false; 
		}else{
			currentPage++;
			return true;
		}
	}
}
