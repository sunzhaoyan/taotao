package com.taotao.rest.service;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamItem;

/**
 * 商品接口
 * 
 * @ClassName: ItemService
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月18日 下午4:37:21
 */
public interface ItemService {
	/**
	 * 根据商品id获得商品对象
	 * 
	 * @Title: getItemById
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @return: TbItem
	 */
	public TbItem getItemById(Long itemId);

	/**
	 * 根据商品id获得商品描述
	 * 
	 * @Title: getItemDescById
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @return: TbItem
	 */
	public TbItemDesc getItemDescById(Long itemId);

	/**
	 * 根据商品id获得商品规格参数
	 * 
	 * @Title: getItemParamById
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @return: TbItem
	 */
	public TbItemParamItem getItemParamById(Long itemId);
}
