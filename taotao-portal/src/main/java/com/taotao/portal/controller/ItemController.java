package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.portal.service.ItemService;

/**
 * 展示商品详情页面
 * 
 * @ClassName: ItemController
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月18日 下午9:42:59
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 展示商品基本信息
	 * 
	 * @Title: showItemInfo
	 * @Description: TODO
	 * @param itemId
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable(value = "itemId") Long itemId, Model model) {
		TbItem item = itemService.getItemById(itemId);
		model.addAttribute("item", item);
		return "item";
	}

	/**
	 * 商品描述
	 * 
	 * @Title: showItemDescInfo
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @return: String
	 */
	@RequestMapping(value="/item/desc/{itemId}", produces=MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
	@ResponseBody
	public String showItemDesc(@PathVariable(value = "itemId") Long itemId) {
		String desc = itemService.getItemDescById(itemId);
		return desc;
	}

	/**
	 * 商品规格参数
	 * @Title: showItemParam 
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @return: String
	 */
	@RequestMapping(value="/item/param/{item}", produces=MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
	@ResponseBody
	public String showItemParam(@PathVariable(value = "item") Long itemId) {
		String param = itemService.getItemDescById(itemId);
		return param;
	}
}
