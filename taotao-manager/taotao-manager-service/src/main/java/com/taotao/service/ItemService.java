package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * 商品service
 * @ClassName: ItemService 
 * @author: szy
 * @date: 2016年10月10日 上午10:16:23
 */
public interface ItemService {
	/**
	 * 根据商品id返回商品对象
	 * 
	 * @Title: getItemById
	 * @param itemId
	 * @return
	 * @return: TbItem
	 */
	public TbItem getItemById(Long itemId);
	
	/**
	 * 分页返回商品对象列表
	 * @Title: getItemList 
	 * @param page
	 * @param rows
	 * @return
	 * @return: EasyUIDataGridResult
	 */
	public EasyUIDataGridResult getItemList(int page, int rows);
}
