package com.taotao.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.pojo.TbUser;

/**
 * 用户接口
 * 
 * @ClassName: UserService
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月19日 下午3:33:27
 */
public interface UserService {
	/**
	 * 获得用户token
	 * @Title: getUserByToken 
	 * @Description: TODO
	 * @param request
	 * @param response
	 * @return
	 * @return: TbUser
	 */
	public TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response);
}
