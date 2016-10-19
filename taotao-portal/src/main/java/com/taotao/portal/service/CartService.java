package com.taotao.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.common.pojo.TaotaoResult;

/**
 * 购物车
 * 
 * @ClassName: CartService
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月19日 下午10:11:30
 */
public interface CartService {
	/**
	 * 添加到购物车
	 * 
	 * @Title: addCert
	 * @Description: TODO
	 * @param itemId
	 *            商品id
	 * @param num
	 *            数量
	 * @return
	 * @return: TaotaoResult
	 */
	public TaotaoResult addCert(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response);
}
