package com.taotao.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 网页内容控制层
 * @ClassName: ContentController 
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月15日 下午4:09:52
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.ExceptionUtil;
import com.taotao.pojo.TbContent;
import com.taotao.rest.service.ContentService;

@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;

	/**
	 * 根据内容分类id获得内容列表
	 * @Title: getContentList 
	 * @Description: TODO
	 * @param cid
	 * @return
	 * @return: TaotaoResult
	 */
	@RequestMapping("/content/{cid}")
	@ResponseBody
	public TaotaoResult getContentList(@PathVariable Long cid) {
		try {
			List<TbContent> list = contentService.getContentList(cid);
			return TaotaoResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * 根据内容分类id删除redis缓存
	 * @Title: syncContent 
	 * @Description: TODO
	 * @param cid
	 * @return
	 * @return: TaotaoResult
	 */
	@RequestMapping("/sync/content/{cid}")
	@ResponseBody
	public TaotaoResult syncContent(@PathVariable Long cid) {
		try {
			TaotaoResult result = contentService.syncContent(cid);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
