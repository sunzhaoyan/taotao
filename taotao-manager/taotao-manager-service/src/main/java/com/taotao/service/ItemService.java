package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
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
	
	/**
	 * 新增商品方法，
	 * @Title: createItem 
	 * @param item 商品对象
	 * @param desc 描述
	 * @param itemParam 规格参数
	 * @return
	 * @return: TaotaoResult
	 */
	public TaotaoResult createItem(TbItem item, String desc, String itemParam);
	
	/**
	 * 根据商品id获得规格参数
	 * @Title: getItemParamHtml 
	 * @param itemId
	 * @return
	 * @return: String
	 */
	public String getItemParamHtml(Long itemId);
}
