package com.taotao.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.common.pojo.TaotaoResult;

/**
 * 用户登录接口
 * 
 * @ClassName: LoginService
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月19日 下午2:23:10
 */
public interface LoginService {
	/**
	 * 登录方法
	 * 
	 * @Title: login
	 * @Description: TODO
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @return: TaotaoResult
	 */
	public TaotaoResult login(String username, String password, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
