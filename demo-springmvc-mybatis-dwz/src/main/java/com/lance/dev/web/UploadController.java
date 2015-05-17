package com.lance.dev.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	private Logger logger = LogManager.getLogger(getClass());
	
	@ResponseBody
	@RequestMapping("upload")
	public String upload(@RequestParam MultipartFile dir) {
		logger.debug("fileName: {}", dir.getOriginalFilename());
		return "{\"error\":0, \"url\":\"filePath\"}";
	}
}
