package com.taotao.portal.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * 获得静态页面接口
 * 
 * @ClassName: StaticPageService
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月19日 上午10:29:56
 */
public interface StaticPageService {
	/**
	 * 根据商品id获得静态页面
	 * 
	 * @Title: getItemHtml
	 * @Description: TODO
	 * @param itemId
	 * @return
	 * @throws Exception
	 * @return: TaotaoResult
	 */
	public TaotaoResult genItemHtml(Long itemId) throws Exception;
}
