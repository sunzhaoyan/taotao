package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.ExceptionUtil;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.rest.service.ItemService;

/**
 * 前台商品控制层
 * 
 * @ClassName: ItemController
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月18日 下午4:43:57
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	/**
	 * 根据商品id查询商品基本信息 Title: getItemById
	 * 
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/base/{itemId}")
	@ResponseBody
	public TaotaoResult getItemById(@PathVariable Long itemId) {
		try {
			TbItem item = itemService.getItemById(itemId);
			return TaotaoResult.ok(item);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * 根据商品id查询商品描述信息
	 * 
	 * @Title: getItemDescById
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @return: TaotaoResult
	 */
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public TaotaoResult getItemDescById(@PathVariable Long itemId) {
		try {
			TbItemDesc itemDesc = itemService.getItemDescById(itemId);
			return TaotaoResult.ok(itemDesc);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * 根据商品id查询商品规格参数信息
	 * 
	 * @Title: getItemParamById
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @return: TaotaoResult
	 */
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public TaotaoResult getItemParamById(@PathVariable Long itemId) {
		try {
			TbItemParamItem itemParamItem = itemService.getItemParamById(itemId);
			return TaotaoResult.ok(itemParamItem);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
