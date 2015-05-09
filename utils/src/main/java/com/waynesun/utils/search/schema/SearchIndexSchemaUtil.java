package com.waynesun.utils.search.schema;


public class SearchIndexSchemaUtil {
//
//	private static final Map<Class<? extends SearchableObject>,Collection<SearchIndexSchema>> SCHEMA_CACHE = new HashMap<Class<? extends SearchableObject>, Collection<SearchIndexSchema>>();
//
//	
//	public static Collection<SearchIndexSchema> getInstance(Class<? extends SearchableObject> clazz){
//		Collection<SearchIndexSchema> schemas = SearchIndexSchemaUtil.SCHEMA_CACHE.get(clazz);
//		if(schemas==null){
//			SearchIndexSchemaUtil.generateSearchIndexSchema(clazz);
//			return SearchIndexSchemaUtil.getInstance(clazz);
//		}
//		
//		return schemas;
//	}
//	
//	private static synchronized void generateSearchIndexSchema(Class<? extends SearchableObject> clazz){
//		Map<String,SearchIndexSchema> schemas = new HashMap<String, SearchIndexSchema>();
//		
//		Method[] methods = clazz.getDeclaredMethods();
//		for(Method method : methods){
//			if(method.isAnnotationPresent(Index.class)){
//				SearchIndexSchema schema = new SearchIndexSchema(method,method.getAnnotation(Index.class));
//				schemas.put(schema.getIndexName(),schema);
//			}
//			
//		}
//		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(clazz);
//		
//		for(PropertyDescriptor propertyDescriptor : propertyDescriptors){
//			if(propertyDescriptor.getReadMethod()!=null&&propertyDescriptor.getReadMethod().isAnnotationPresent(Index.class)){
//				SearchIndexSchema schema = new SearchIndexSchema(propertyDescriptor.getReadMethod(),propertyDescriptor.getReadMethod().getAnnotation(Index.class));
//				schemas.put(schema.getIndexName(),schema);
//			}
//		}
//		
//		SearchIndexSchemaUtil.SCHEMA_CACHE.put(clazz, schemas.values());
//	}
}
