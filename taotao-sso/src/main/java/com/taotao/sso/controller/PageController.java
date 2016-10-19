package com.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制
 * 
 * @ClassName: PageController
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月19日 下午2:49:48
 */
@Controller
public class PageController {
	/**
	 * 展示登录页面
	 */
	@RequestMapping("/page/login")
	public String showLogin() {
		return "login";
	}

	/**
	 * 展示注册页面
	 */
	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}

}
