package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;
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
	
	/**
	 * 根据父分类id删除redis缓存
	 * @Title: syncItemCat 
	 * @Description: TODO
	 * @param parentId
	 * @return
	 * @return: TaotaoResult
	 */
	public TaotaoResult syncItemCat(Long parentId);
}
