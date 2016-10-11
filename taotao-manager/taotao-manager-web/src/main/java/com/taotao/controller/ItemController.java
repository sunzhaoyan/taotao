package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
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
	 * @param itemId
	 * @return
	 * @return: TbItem
	 */
//	@RequestMapping("/item/{itemId}")
//	@ResponseBody
//	private TbItem getItemById(@PathVariable Long itemId) {
//		TbItem item = itemService.getItemById(itemId);
//		return item;
//	}

	/**
	 * 分页返回商品集合
	 * 
	 * @Title: getItemList
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

	/**
	 * 商品新增
	 * 
	 * @Title: createItem
	 * @param item
	 * @param desc
	 * @return
	 * @return: TaotaoResult
	 */
	@RequestMapping(value = "/item/save", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem item, String desc, String itemParam) {
		TaotaoResult result = itemService.createItem(item, desc, itemParam);
		return result;
	}

	/**
	 * 查看商品规格参数
	 * 
	 * @Title: showItemParam
	 * @param itemId
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/item/{itemId}")
	public String showItemParam(@PathVariable Long itemId, Model model) {
		String html = itemService.getItemParamHtml(itemId);
		model.addAttribute("html", html);
		return "itemparam";
	}

}
