package com.waynesun.utils.search.solr.query;



/**
 * 已实现：and,or,not,order,range
 * @author xiayong
 *
 */
public class Query extends AbstractSolrQuery{
//	private List<FulltextSearchSort> orders=new ArrayList<FulltextSearchSort>();
//	
//	private String[] highlightFields;
//	
//	public Query(String field, String value){
//		this.add(field, value,"");
//	}
//	public Query(String field, String value,String[] highlightFields){
//		this.add(field, value,"");
//	}
//	protected Query(){
//		
//	}
//	
//	/**
//	 * @param field
//	 * @param isAsc 是否升序
//	 * @return
//	 */
//	public Query addSort(String field, boolean isAsc) {
//		orders.add(new FulltextSearchSort(field,isAsc ? ORDER.asc : ORDER.desc));
//		return this;
//	}
//	public Query and(String field, String value) {
//		add(field, value, " AND ");
//		return this;
//	}
//	public Query not(String field, String value) {
//		add(field, value, " NOT ");
//		return this;
//	}
//
//	public Query or(String field, String value) {
//		add(field, value, " OR ");
//		return this;
//	}
//
//	// mod_date:[20020101 TO 20030101]
//	public Query andRange(String field, Object lowLimit , Object highLimit) {
//		if(lowLimit!=null && highLimit !=null){
//			q.append(" AND ").append(field).append(":[").append(getString(lowLimit)).append(" TO ").append(getString(highLimit)).append("]");
//			//q += " AND " + field + ":[" + getString(lowLimit) + " TO " + getString(highLimit) + "]";
//		}else if(lowLimit != null){
//			q.append(" AND ").append(field).append(":[").append(getString(lowLimit)).append(" TO ").append("*").append("]");
//			//q += " AND " + field + ":[" + getString(lowLimit) + " TO *]";
//		}else if(highLimit != null){
//			q.append(" AND ").append(field).append(":[").append("*").append(" TO ").append(getString(highLimit)).append("]");
//			//q += " AND " + field + ":[ * TO " + getString(highLimit) + "]";
//		}
//		return this;
//	}
//
//	private String getString(Object o) {
//		return (o instanceof Date) ? DateUtil.getThreadLocalDateFormat().format(o): o.toString();
//	}
//
//	
//	protected Query add(String field, String value, String condition) {
//		if(StringUtils.contains(field, "*")&&StringUtils.equals("*", value)) {
//			if(!(StringUtils.equals(field, "*")&&StringUtils.equals("*", value)))
//				throw new BizException("filed里不能带*.(例外：value为*时，field可为*)");
//		}
//		q.append(condition).append(field).append(":").append(value);
//		return this;
//	}
//
//
//	protected Query add(String field, String value) {
//		return this.add(field, value, "");
//	}
//
//	@Override
//	public String toString() {
//		String queryString = q.toString();
//		return StringUtils.isBlank(queryString) ? "*:*" : queryString;
//	}
//	public List<FulltextSearchSort> getOrders() {
//		return orders;
//	}
//	public void setOrders(List<FulltextSearchSort> orders) {
//		this.orders = orders;
//	}
//	public String[] getHighlightFields() {
//		return highlightFields;
//	}
//	public void setHighlightFields(String[] highlightFields) {
//		this.highlightFields = highlightFields;
//	}
//



}
