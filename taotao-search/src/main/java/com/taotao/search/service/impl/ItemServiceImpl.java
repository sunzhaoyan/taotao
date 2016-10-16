package com.taotao.search.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.mapper.ItemMapper;
import com.taotao.search.pojo.SearchItem;
import com.taotao.search.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private SolrServer solrServer;
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public TaotaoResult importItems() {
		List<SearchItem> itemList = itemMapper.getItemList();
		for (SearchItem searchItem : itemList) {
			SolrInputDocument document = new SolrInputDocument();
			document.setField("id", searchItem.getId());
			document.setField("item_title", searchItem.getTitle());
			document.setField("item_image", searchItem.getImage());
			document.setField("item_sell_point", searchItem.getSell_point());
			document.setField("item_desc", searchItem.getItem_desc());
			document.setField("item_price", searchItem.getPrice());
			document.setField("item_category_name", searchItem.getCategory_name());
			try {
				solrServer.add(document);
				solrServer.commit();
			} catch (SolrServerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return TaotaoResult.ok();
	}

}
