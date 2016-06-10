package com.lance.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	@Autowired
	private ProducerService producerService;
	
	@RequestMapping(value={"/", "", "index"})
	public String index() {
		return "index.jsp";
	}

	@ResponseBody
	@RequestMapping("click")
	public void click() {
		String message = "Hello Queue Message.";
		producerService.sendTextQueueMessage(message);
	}
}
