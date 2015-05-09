package com.waynesun.dao.query.function;

import java.util.HashMap;
import java.util.Map;

import com.waynesun.dao.query.QueryFunction;

public class FunctionAdapterFactory {
	/**SQL函数适配器缓存*/
	private static final Map<QueryFunction, AbstractFunctionAdapter> ADAPTERS = new HashMap<QueryFunction, AbstractFunctionAdapter>();

	static{
		initHibernateFunctionAdapters();
	}

	private static void initHibernateFunctionAdapters() {
		ADAPTERS.put(QueryFunction.ACG, new AvgAdapter());
		ADAPTERS.put(QueryFunction.COUNT, new CountAdapter());
		ADAPTERS.put(QueryFunction.MAX, new MaxAdapter());
		ADAPTERS.put(QueryFunction.MIN, new MinAdapter());
		ADAPTERS.put(QueryFunction.SUM, new SumAdapter());
	}
	
	public static AbstractFunctionAdapter getAdapter(QueryFunction function){
		return ADAPTERS.get(function);
	}
}
