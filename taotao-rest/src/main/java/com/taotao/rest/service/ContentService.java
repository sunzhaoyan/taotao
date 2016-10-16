package com.taotao.rest.service;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * 首页内容接口
 * @ClassName: ContentService 
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月15日 下午4:03:26
 */
public interface ContentService {
	/**
	 * 根据分类id获得内容列表
	 * @Title: getContentList 
	 * @Description: TODO
	 * @param cid
	 * @return
	 * @return: List<TbContent>
	 */
	public List<TbContent> getContentList(Long cid);
	
	/**
	 * 根据内容分类id,删除redis缓存
	 * @Title: syncContent 
	 * @Description: TODO
	 * @param cid
	 * @return
	 * @return: TaotaoResult
	 */
	public TaotaoResult syncContent(Long cid);
}
