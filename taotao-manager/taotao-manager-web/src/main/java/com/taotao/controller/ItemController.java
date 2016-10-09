package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	/**
	 * item接口
	 */
	@Autowired
	private ItemService itemService;

	/**
	 * 根据商品id返回商品对象
	 * 
	 * @Title: getItemById
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @return: TbItem
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	private TbItem getItemById(@PathVariable Long itemId) {
		TbItem item = itemService.getItemById(itemId);
		return item;
	}

	/**
	 * 分页返回商品集合
	 * 
	 * @Title: getItemList
	 * @Description: TODO
	 * @param page
	 * @param rows
	 * @return
	 * @return: EasyUIDataGridResult
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

}
