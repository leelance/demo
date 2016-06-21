package com.lance.dubbo.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lance.dubbo.modal.UserInfo;
import com.lance.dubbo.service.UserService;

@Controller
public class IndexController {
	@Autowired
	private UserService userService;

	@RequestMapping(value={"", "/", "index"})
	public String index(Model model) {
		UserInfo info = userService.findOne(1);
		model.addAttribute("info", info);
		return "index.jsp";
	}
}
