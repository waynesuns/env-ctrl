package com.fusioninfo.utils.search.solr.service;

import java.util.HashMap;
import java.util.Map;

//TODO 配置文件,spring文件
//TODO 服务器的翻译
public class SolrContext {
	private String solrServerUrl;
	private static Map<String,SolrService> mySolrServiceMap = new HashMap<String, SolrService>();
	private static final String DEAULT_CORE_NAME="core";

	public SolrService getMySolrService(String coreName) {
		if(coreName==null){
			coreName = SolrContext.DEAULT_CORE_NAME;
		}
		SolrService mySolrService = mySolrServiceMap.get(coreName);
		if (mySolrService == null){
			mySolrService = new SolrServiceImpl(solrServerUrl+coreName);
			mySolrServiceMap.put(coreName, mySolrService);
		}
			
		return mySolrService;
	}

	public String getSolrServerUrl() {
		return solrServerUrl;
	}

	public void setSolrServerUrl(String solrServerUrl) {
		this.solrServerUrl = solrServerUrl;
	}
	
	
}
