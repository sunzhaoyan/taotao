package com.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.taotao.search.pojo.SearchResult;

public interface SearchDao{
	/**
	 * solr查询dao
	 * @Title: search 
	 * @Description: TODO
	 * @param solrQuery
	 * @return
	 * @return: SearchResult
	 */
	public SearchResult search(SolrQuery solrQuery) throws Exception;
}
