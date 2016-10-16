package com.taotao.search.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * solr
 * @ClassName: ItemService 
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月16日 下午8:08:43
 */
public interface ItemService {
	/**
	 * 导入商品信息到solr
	 * @Title: importItems 
	 * @Description: TODO
	 * @return
	 * @return: TaotaoResult
	 */
	public TaotaoResult importItems();
}
