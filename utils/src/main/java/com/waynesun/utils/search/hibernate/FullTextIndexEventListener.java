package com.waynesun.utils.search.hibernate;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.waynesun.utils.observer.ObserverParam;
import com.waynesun.utils.search.SearchableFile;
import com.waynesun.utils.search.SearchableObject;
import com.waynesun.utils.search.solr.service.SolrContext;
import com.waynesun.utils.search.task.AbstractFullTextIndexBuildTask;
import com.waynesun.utils.search.task.FullTextFileIndexBuildTask;
import com.waynesun.utils.search.task.FullTextIndexBuildTask;

@Service
public class FullTextIndexEventListener implements Observer{

	@Autowired
	private SolrContext solrContext;
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void doSave(SearchableObject searchableObject,int operateType){
		AbstractFullTextIndexBuildTask task = null;
		if(searchableObject instanceof SearchableFile){
			task = new FullTextFileIndexBuildTask();
			
		}else{
			task = new FullTextIndexBuildTask();
		}
		this.doSave(task, searchableObject, operateType);
	}
	
	private void doSave(AbstractFullTextIndexBuildTask task,SearchableObject searchableObject,int operateType){
		task.setOwnerClass(searchableObject.getClass().getName());
		task.setOwnerId(searchableObject.getId());
		task.setOperateType(searchableObject.getOperateType(operateType));
		task.update();
	}

	@Override
	public void update(Observable observable, Object arg) {
		ObserverParam observerParam = (ObserverParam)arg;
		if(observable instanceof SearchableObject){
			SearchableObject searchableObject = (SearchableObject)observable;
			if(!searchableObject.isIgonre(observerParam.getOperateType())){
				this.doSave(searchableObject,observerParam.getOperateType());
			}
		}
		
	}
	public SolrContext getSolrContext() {
		return solrContext;
	}
	public void setSolrContext(SolrContext solrContext) {
		this.solrContext = solrContext;
	}

}
