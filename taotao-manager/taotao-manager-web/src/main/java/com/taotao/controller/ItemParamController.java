package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemParamService;

/**
 * 商品规格参数模板controller
 * 
 * @author szy
 *
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired
	ItemParamService itemParamService;

	/**
	 * 分页返回 商品规格参数模板
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItemParamList(Integer page, Integer rows) {
		EasyUIDataGridResult result = itemParamService.getItemList(page, rows);
		return result;
	}

	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable("cid") Long cid) {
		TaotaoResult taotaoResult = itemParamService.getItemParamByCid(cid);
		return taotaoResult;
	}

	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
		TaotaoResult result = itemParamService.insertItemParam(cid, paramData);
		return result;
	}

}
