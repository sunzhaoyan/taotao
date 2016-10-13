package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

/**
 * 
 * @ClassName ContentCatgoryService
 * @Description 内容分类接口
 * @author szy
 * @Date 2016年10月13日 下午10:03:17
 * @version 1.0.0
 */
public interface ContentCategoryService {
	/**
	 * 
	 * @Description 根据父id获得子节点
	 * @param parentId
	 * @return
	 * 2016年10月13日 下午10:05:44
	 */
	public List<EasyUITreeNode> getContentCatList(Long parentId);
	
	/**
	 * 
	 * @Description 添加首页内容分类
	 * @param parentId
	 * @param name
	 * @return
	 * @Date 2016年10月13日 下午10:28:52
	 */
	public TaotaoResult insertCatgory(Long parentId, String name);
}
