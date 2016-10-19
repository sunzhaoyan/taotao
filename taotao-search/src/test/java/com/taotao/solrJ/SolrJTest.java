package com.taotao.solrJ;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJTest {

	@Test
	public void testSolrj() {
		HttpSolrServer solrServer = new HttpSolrServer("http://192.168.87.129:8080/solr");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "solrtest01");
		document.addField("item_title", "测试商品");
		document.addField("item_sell_point", "卖点");
		try {
			solrServer.add(document);
			solrServer.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testQuery() {
		HttpSolrServer solrServer = new HttpSolrServer("http://192.168.87.129:8080/solr");
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		try {
			QueryResponse response = solrServer.query(query);
			SolrDocumentList results = response.getResults();
			for (SolrDocument solrDocument : results) {
				System.out.println(solrDocument.get("id"));
				System.out.println(solrDocument.get("item_title"));
				System.out.println(solrDocument.get("item_sell_point"));
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
	}
}
