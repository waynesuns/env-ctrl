package com.waynesun.utils.search.solr.service;


public class SolrServiceImpl implements SolrService {
//	protected static final Log logger = LogFactory.getLog(SolrServiceImpl.class);
//	private HttpSolrServer solrServer;
//	//@Resource(name="accessAuthorityValidator")
//	//private AccessAuthorityValidator accessAuthorityValidator;
//
//	public SolrServiceImpl(String url) {
//		init(url);
//	}
//
//	public SolrServer getSolrServer() {
//		return solrServer;
//	}
//
//	private void init(String url) {
//		try {
//			solrServer = new HttpSolrServer(url);
//			solrServer.setSoTimeout(50000000); // socket read timeout
//			solrServer.setConnectionTimeout(50000000);
//			solrServer.setDefaultMaxConnectionsPerHost(100);
//			solrServer.setMaxTotalConnections(100);
//			solrServer.setFollowRedirects(false); // defaults to false
//			solrServer.setAllowCompression(true);
//			solrServer.setMaxRetries(1); // defaults to 0. > 1 not recommended.
//			solrServer.setParser(new XMLResponseParser());
//
//		} catch (Exception e) {
//			logger.error("初始化SOLR服务器出错", e);
//			throw new BizException("初始化SOLR服务器出错", e);
//		}
//
//	}
//
//	@Override
//	public Result saveOrUpdate(SearchableObject searchable) throws Exception {
//		List<SearchableObject> searchables = new ArrayList<SearchableObject>();
//		searchables.add(searchable);
//		return this.saveOrUpdate(searchables);
//	}
//
//	@Override
//	public void saveOrUpdateFile(SearchableFile searchableFile) throws Exception {
//		File file = searchableFile.getIndexFile();
//		if(file!=null && file.exists()){
//			if(searchableFile.isIndexFile()){
//				ContentStreamUpdateRequest request = new ContentStreamUpdateRequest("/update/extract");  
//				request.addFile(searchableFile.getIndexFile(), "application/octet-stream");  
//				this.addSolrFileInputParam(searchableFile, request);
//				request.setAction(AbstractUpdateRequest.ACTION.COMMIT, true, true);  
//				solrServer.request(request);
//			}else{
//				this.saveOrUpdate(searchableFile);
//			}
//			
//		}
//	}
//
//	private SolrInputDocument generatSolrInputDocument(SearchableObject searchable) throws SolrServerException, IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException {
//		SolrInputDocument doc = new SolrInputDocument();
//		Object id = searchable.getId();
//		if (null == id) {
//			throw new BizException("searchable id is null");
//		} 
//		
//		Collection<SearchIndexSchema> schemas = SearchIndexSchemaUtil.getInstance(searchable.getClass());
//		for(SearchIndexSchema schema : schemas){
//			schema.addField(doc, searchable);
//		}
//		return doc;
//	}
//
//	private void addSolrFileInputParam(SearchableFile searchableFile,ContentStreamUpdateRequest request) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException{
//		Collection<SearchIndexSchema> schemas = SearchIndexSchemaUtil.getInstance(searchableFile.getClass());
//		for(SearchIndexSchema schema : schemas){
//			schema.addFileInputParam(request, searchableFile);
//		}
//	}
//	public Result indexDelete(SearchableObject searchable) throws Exception {
//		return this.indexDelete(searchable.getId());
//	}
//	public Result indexDelete(String id) throws Exception {
//		UpdateRequest req = new UpdateRequest("/update");
//		req.deleteById(id);
//		req.setParam(UpdateParams.COMMIT, "true");
//		UpdateResponse response = req.process(solrServer);
//		return Result.getResult(response.getStatus() == 0, response.getElapsedTime());
//	}
//
//
//
//	@Override
//	// TODO 分组，分页,ge等参看lucene语法
//	// FIXME 将persistence持久解析的document缓存起来
//	public QueryResult query(Query q) throws Exception {
//		QueryResult ret = new QueryResult();
//
//		try {
//			SolrQuery query = new SolrQuery();
//			query.setStart(q.getPages().getFirstRow()-1);
//			query.setRows(q.getPages().getPageSize());
//			query.setQuery(q.toString());
//			
//			for (FulltextSearchSort sort : q.getOrders()){
//				query.addSort(sort.getName(), sort.getOrder());
//			}
//			query.addSort("score", ORDER.desc);
//			query.addSort("createTime", ORDER.desc);
//
//			query.setHighlightSimplePre("<font class=\"highlight\">");
//			query.setHighlightSimplePost("</font>");
//			
//			
//			for (String field : q.getHighlightFields()) {
//				query.addHighlightField(field);
//			}
//			
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(DateUtils.truncate(new Date(), Calendar.DATE));
//			cal.add(Calendar.DAY_OF_YEAR, -10);
//			
//			//query.addDateRangeFacet("createTime", cal.getTime(), new Date(), "1DAY");
//			//query.addNumericRangeFacet("createTimeMillis", new Number("1366959263271"), new Long("1366959263274"), "");
//
//			
//			QueryResponse rsp = solrServer.query(query);
//			ret.setTotalAmt(rsp.getResults().getNumFound());
//			ret.setElapsedTime(Long.valueOf(rsp.getHeader().get("QTime").toString()));
//			
//
//			Map<String, Map<String, List<String>>> highlighting = rsp.getHighlighting();
//			for(SolrDocument doc : rsp.getResults()){
//				Map<String, List<String>> hlData = highlighting.get(doc.getFieldValue("id"));
//				if(hlData!=null){
//					doc.put("highlightedText", hlData);
//				}
//				
//			}
//			q.getPages().setTotalRow((int)ret.getTotalAmt());
//			
//			ret.setSolrDocumentList(rsp.getResults());
//			
//			ListIterator<SolrDocument> iterator = ret.getSolrDocumentList().listIterator();
//			
//			while(iterator.hasNext()){
//				SolrDocument solrDocument = iterator.next();
//				solrDocument.put("isAccessable", AccessAuthorityValidatorFactory.isAccessable((String)solrDocument.get("ownerType"), (String)solrDocument.get("ownerId"), (String)solrDocument.get("createUserId")));
//			}
//		} catch (Exception e) {
//			logger.error("SOLR查询出错:" + q.toString(), e);
//			throw new BizException("SOLR查询出错:" + q.toString() + "," + e.getMessage(), e);
//		}
//		return ret;
//	}
//
//	@Override
//	public Result saveOrUpdate(List<SearchableObject> searchables)throws Exception {
//		UpdateRequest req = new UpdateRequest("/update");
//		for(SearchableObject searchable : searchables){
//			req.add(generatSolrInputDocument(searchable));
//		}
//		req.setParam(UpdateParams.COMMIT, "true");
//		UpdateResponse response = req.process(solrServer);
//
//		return Result.getResult(response.getStatus() == 0, response.getElapsedTime());
//		
//	}
//
///*
//	@Override
//	public List<String> suggest(String q) throws Exception {
//		List<String> ret = new ArrayList<String>();
//		SolrQuery query = new SolrQuery();
//		query.setQueryType("/suggest");
//		query.setQuery(q);
//		QueryResponse rsp = solrServer.query(query);
//		SpellCheckResponse spellCheckResponse = rsp.getSpellCheckResponse();
//		// ret.setqTime(Long.valueOf(rsp.getHeader().get("QTime").toString()));
//
//		logger.info(spellCheckResponse);
//		// List<String> beans = new ArrayList<String>();
//		List<Suggestion> suggestions = spellCheckResponse.getSuggestions();
//		// long found = 0;
//		if (suggestions.size() > 1) {
//			ret.add(spellCheckResponse.getCollatedResult());
//		}
//		for (Suggestion suggestion : suggestions) {
//			ret.addAll(suggestion.getAlternatives());
//			// found += suggestion.getNumFound();
//		}
//		// ret.setResult(beans);
//		// ret.setNumFound(found);
//		return ret;
//	}
//
//	@Override
//	public QueryResponse facetQuery(FacetQuery q) throws Exception {
//		SolrQuery query = new SolrQuery();
//		query.setStart(q.getStart());
//		query.setRows(q.getRows());
//		query.setQuery(q.toString());
//		for (Entry<String, ORDER> order : q.getOrder().entrySet()) {
//			query.addSortField(order.getKey(), order.getValue());
//		}
//		query.setFacet(true);
//
//		for (String field : q.facetFields) {
//			query.addFacetField(field);
//		}
//		for (String field : q.highlightFields) {
//			query.addHighlightField(field);
//		}
//		for (String field : q.facetQuerys) {
//			query.addFacetQuery(field);
//		}
//		for (DateRange field : q.dateRangeFields) {
//			query.addDateRangeFacet(field.getField(), field.getStart(), field.getEnd(), field.getGap());
//		}
//		for (NumericRange field : q.numericRangeFields) {
//			query.addNumericRangeFacet(field.getField(), field.getStart(), field.getEnd(), field.getGap());
//		}
//		if (StringUtils.isNotEmpty(q.getFacetPrefix()))
//			query.setFacetPrefix(q.getFacetPrefix());
//		
//		query.setHighlightSimplePre("<font color=\"red\">");
//		query.setHighlightSimplePost("</font>");
//
//		query.setFacetMinCount(1);
//
//		QueryResponse rsp = solrServer.query(query);
//		List<FacetField> facetFields = rsp.getFacetFields();
//		List<RangeFacet> facetRanges = rsp.getFacetRanges();
//		Map<String, Map<String, List<String>>> highlighting = rsp.getHighlighting();
//		Map<String, FieldStatsInfo> fieldStatsInfo = rsp.getFieldStatsInfo();
//
//		Iterator<SolrDocument> iter = rsp.getResults().iterator();
//		return rsp;
//	}*/

}
