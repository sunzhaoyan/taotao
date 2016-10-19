package com.taotao.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.ExceptionUtil;
import com.taotao.sso.service.LoginService;

/**
 * 用户登录控制层
 * 
 * @ClassName: LoginController
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月19日 下午2:34:56
 */
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

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
	 * @return: TaotaoResult
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult login(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			TaotaoResult result = loginService.login(username, password, request, response);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
