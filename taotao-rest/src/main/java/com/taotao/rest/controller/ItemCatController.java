package com.taotao.rest.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.ExceptionUtil;
import com.taotao.common.util.JSONUtils;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;

/**
 * 
 * @author szy
 *
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		ItemCatResult result = itemCatService.getItemCatList();
		String json = null;
		try {
			if (StringUtils.isBlank(callback)) {
				// 需要把result转换成字符串
				json = JSONUtils.obj2json(result);
				return json;
			}
			// 如果字符串不为空，需要支持jsonp调用
			// 需要把result转换成字符串
			json = JSONUtils.obj2json(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return callback + "(" + json + ");";
	}

	/**
	 * 根据父分类id删除redis缓存
	 * @Title: syncItemCat 
	 * @Description: TODO
	 * @param parentId
	 * @return
	 * @return: TaotaoResult
	 */
	@RequestMapping("/sync/item/cat/{parentId}")
	@ResponseBody
	public TaotaoResult syncItemCat(@PathVariable Long parentId) {
		try {
			TaotaoResult taotaoResult = itemCatService.syncItemCat(parentId);
			return taotaoResult;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
