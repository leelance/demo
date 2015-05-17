package com.lance.dev.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {

	@ResponseBody
	@RequestMapping("upload")
	public String upload() {
		return null;
	}
}
