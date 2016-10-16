package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.ExceptionUtil;
import com.taotao.search.service.ItemService;

/**
 * 商品搜索控制层
 * 
 * @ClassName: ItemController
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月16日 下午8:19:54
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	/**
	 * 导入商品索引到solr
	 * @Title: importAll 
	 * @Description: TODO
	 * @return
	 * @return: TaotaoResult
	 */
	@RequestMapping("/importAll")
	@ResponseBody
	public TaotaoResult importAll() {
		try {
			TaotaoResult result = itemService.importItems();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
