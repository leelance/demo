package com.lance.dev.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/")
public class IndexController {
	
	/**
	 * 跳转首页
	 * @return
	 */
	@RequestMapping("index")
	public String index(){
		return "user/index";
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("add")
	public String add(){
		return "user/add";
	}
}
