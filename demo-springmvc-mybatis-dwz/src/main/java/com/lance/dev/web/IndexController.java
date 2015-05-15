package com.lance.dev.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/")
public class IndexController {
	
	@RequestMapping("index")
	public String index(){
		return "user/index";
	}
}
