package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * 内容管理接口
 * @ClassName: ContentService 
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月15日 下午5:58:03
 */
public interface ContentService {
	/**
	 * 新增内容
	 * @Title: insertContent 
	 * @Description: TODO
	 * @param content
	 * @return
	 * @return: TaotaoResult
	 */
	public TaotaoResult insertContent(TbContent content);
}
