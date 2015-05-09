package com.waynesun.utils.search.schema;



public class SearchIndexSchema {
//	private Method indexPropertyReadMethod;
//	private Index indexAnnotation;
//	private String indexPropertyName;
//	
//	
//	protected SearchIndexSchema(Method indexPropertyReadMethod,Index indexAnnotation){
//		if(indexPropertyReadMethod==null){
//			throw new BizException("indexPropertyReadMethod:"+indexPropertyName+", is null");
//		}
//		if(indexAnnotation==null){
//			throw new BizException("indexPropertyReadMethod"+indexPropertyName+", is null");
//		}
//		this.indexAnnotation = indexAnnotation;
//		this.indexPropertyReadMethod = indexPropertyReadMethod;
//		this.indexPropertyName = this.getName(indexPropertyReadMethod.getName());
//	}
//	private String getName(String methodName){
//		if(methodName.startsWith("get")){
//			methodName = methodName.substring(3);
//			methodName = methodName.substring(0,1).toLowerCase()+methodName.substring(1);
//		}
//		return methodName;
//	}
//	private Object getIndexValue(SearchableObject object) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
//		return indexPropertyReadMethod.invoke(object, new Object[0]);
//	}
//	protected String getIndexName(){
//		String name = indexAnnotation.name();
//		return StringUtils.isEmpty(name)?indexPropertyName:name;
//	}
//	public void addField(SolrInputDocument doc,SearchableObject searchable) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException{
//		Object value = this.getIndexValue(searchable);
//		
//		if(value instanceof Collection){
//			//System.out.println("((Collection<?>)value).size():"+((Collection<?>)value).size());
//			for(Object obj : (Collection<?>)value){
//				//System.out.println(this.getIndexName()+":"+this.getValue(obj));
//				doc.addField(this.getIndexName(), this.getValue(obj));
//			}
//		}else{
//			doc.addField(this.getIndexName(), this.getValue(value));
//		}
//		
//		
//	}
//	public void addFileInputParam(ContentStreamUpdateRequest request,SearchableObject searchable) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException{
//		Object value = this.getIndexValue(searchable);
//
//		if(value instanceof Collection){
//			//System.out.println("((Collection<?>)value).size():"+((Collection<?>)value).size());
//			for(Object obj : (Collection<?>)value){
//				//System.out.println(this.getIndexName()+":"+this.getValue(obj));
//				request.setParam(ExtractingParams.LITERALS_PREFIX+this.getIndexName(), this.getStringValue(this.getValue(obj)));
//			}
//		}else{
//			request.setParam(ExtractingParams.LITERALS_PREFIX+this.getIndexName(), this.getStringValue(this.getValue(value)));
//		}
//		
//		
//	}
//	private String getStringValue(Object o) {
//		if(o==null){
//			return null;
//		}
//		return (o instanceof Date) ? DateUtil.getThreadLocalDateFormat().format(o): o.toString();
//	}
//	private Object getValue(Object value) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
//		String propertyNameChain = indexAnnotation.propertyNameChain();
//		if(StringUtils.isEmpty(propertyNameChain)){
//			return value;
//		}else{
//			return BeanUtil.getProperty(value, propertyNameChain);
//		}
//	}
}
