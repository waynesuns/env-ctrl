package com.waynesun.utils.search.task;

import org.springframework.stereotype.Service;

@Service
public class FullTextIndexBuildTaskService {
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	public void exceuteTask(SolrService solrService,FullTextFileIndexBuildTask task) {
//		try {
//
//			UserUtils.setUser(task.getCreateUser());
//			if(task.getOperateType().equals(Const.OPERATE_TYPE_DELETE)){
//				solrService.indexDelete(task.getOwnerId());
//			}else{
//				SearchableFile owner = (SearchableFile)task.getOwner();
//				if(owner==null){
//					solrService.indexDelete(task.getOwnerId());
//				}else{
//					solrService.saveOrUpdateFile(owner);
//				}
//			}
//			task.delete();
//		} catch (Exception e) {
//			System.out.println(task.getId()+"|"+task.getOwnerId());
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//		
//	}
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	public void exceuteTask(SolrService solrService,List<FullTextIndexBuildTask> tasks) {
//		try {
//
//			if(!tasks.isEmpty()){
//				UserUtils.setUser(tasks.get(0).getCreateUser());
//			}
//			
//			List<SearchableObject> objects = new ArrayList<SearchableObject>();
//			List<String> ownerIds = new ArrayList<String>();
//			for(FullTextIndexBuildTask task : tasks){
//				if(task.getOperateType().equals(Const.OPERATE_TYPE_DELETE)){
//					solrService.indexDelete(task.getOwnerId());
//				}else{
//					SearchableObject owner = (SearchableObject)task.getOwner();
//					if(owner==null){
//						solrService.indexDelete(task.getOwnerId());
//					}else if(!ownerIds.contains(task.getOwnerId())){
//						objects.add(owner);
//						ownerIds.add(task.getOwnerId());
//					}
//				}
//			}
//			solrService.saveOrUpdate(objects);
//			for(FullTextIndexBuildTask task : tasks){
//				task.delete();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//		
//	}
}
