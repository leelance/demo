package com.lance.shiro.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/**
	 * Go login.jsp
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "login.jsp";
	}
	
	/**
	 * Go login
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		UsernamePasswordToken upt = new UsernamePasswordToken(account, password);
		Subject subject = SecurityUtils.getSubject();
		subject.login(upt);
		return "redirect:/index";
	}
	
	/**
	 * Exit
	 * @return
	 */
	@RequestMapping("logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/index";
	}
}
