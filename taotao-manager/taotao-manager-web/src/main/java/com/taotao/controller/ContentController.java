package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.HttpClientUtil;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**
 * 内容管理 控制层
 * 
 * @ClassName: ContentController
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月15日 下午5:32:57
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;

	/**
	 * 新增内容
	 * 
	 * @Title: insertContent
	 * @Description: TODO
	 * @param content
	 * @return
	 * @return: TaotaoResult
	 */
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		// 新增商品时删除redis缓存
		HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
		return result;
	}
}
