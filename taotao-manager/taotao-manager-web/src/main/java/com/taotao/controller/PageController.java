package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页Controller
 * 
 * @ClassName: PageController
 * @Description: 跳转到首页
 * @author: szy
 * @date: 2016年9月30日 上午10:13:08
 */
@Controller
public class PageController {
	/**
	 * 跳转到首页
	 * 
	 * @Title: showIndex
	 * @return index逻辑视图
	 * @return: String
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	/**
	 * 跳转到指定页面
	 * 
	 * @Title: showPage
	 * @param page
	 * @return
	 * @return: String
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
