package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;


public interface ItemService {
	/**
	 * 根据商品id返回商品对象
	 * 
	 * @Title: getItemById
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @return: TbItem
	 */
	public TbItem getItemById(Long itemId);
	
	/**
	 * 分页返回商品对象列表
	 * @Title: getItemList 
	 * @Description: TODO
	 * @param page
	 * @param rows
	 * @return
	 * @return: EasyUIDataGridResult
	 */
	public EasyUIDataGridResult getItemList(int page, int rows);
}
