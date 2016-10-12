package com.taotao.rest.service;

import com.taotao.rest.pojo.ItemCatResult;
/**
 * 商品分类service
 * @author szy
 *
 */
public interface ItemCatService {
	/**
	 * 根据parentid查询子节点列表，并递归调用
	 * @return
	 */
	public ItemCatResult getItemCatList();
}
