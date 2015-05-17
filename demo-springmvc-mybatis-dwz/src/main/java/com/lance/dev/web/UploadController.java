package com.lance.dev.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {
	private Logger logger = LogManager.getLogger(getClass());
	
	@ResponseBody
	@RequestMapping("upload")
	public String upload(HttpServletRequest request, HttpServletResponse response) {
		String dirName = request.getParameter("dir");
		logger.debug("fileName: {}", dirName);
		return "{\"error\":0, \"url\":\""+System.currentTimeMillis()+"\"}";
	}
}
