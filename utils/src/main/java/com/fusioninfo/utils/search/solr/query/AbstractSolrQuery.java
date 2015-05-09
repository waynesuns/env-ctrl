package com.fusioninfo.utils.search.solr.query;

import com.fusioninfo.pojo.Pages;




public abstract class AbstractSolrQuery {
	protected StringBuffer q = new StringBuffer();
	private Pages pages = new Pages();
	
	public Pages getPages() {
		return pages;
	}
	public void setPages(Pages pages) {
		this.pages = pages;
	}
	
	
}
