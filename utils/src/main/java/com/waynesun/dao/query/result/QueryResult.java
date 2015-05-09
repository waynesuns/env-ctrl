package com.waynesun.dao.query.result;

import java.util.List;

import com.waynesun.dao.query.pages.ResultPages;

/**
 * @ClassName: QueryResult
 * @Description: 查询结果
 * @author zhengnan
 * @date 2014年4月1日 下午1:07:32
 * @param <T>
 */
public class QueryResult<T> {
	private List<T> results;
	private ResultPages pages;

	public QueryResult(List<T> results, ResultPages pages) {
		this.results = results;
		this.pages = pages;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public ResultPages getPages() {
		return pages;
	}

	public void setPages(ResultPages pages) {
		this.pages = pages;
	}
}