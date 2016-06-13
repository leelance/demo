package com.lance.mq;

import java.util.Date;
import java.util.Random;

import javax.jms.JMSException;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	Logger logger = LogManager.getLogger(getClass());
	@Autowired
	private ProducerService producerService;
	
	@RequestMapping(value={"/", "", "index"})
	public String index() {
		return "index.jsp";
	}

	@ResponseBody
	@RequestMapping("click")
	public void click() {
		String message = "Hello Queue Message. Date: "+DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		
		//发送消息不返回值
		//producerService.sendTextQueueMessage(message);
		
		/*发送消息带返回值
		try {
			String result = producerService.sendTextQueueMessageAndReceive(message);
			logger.info("IndexController ====> result: {}, isSuccess: {}", result, result.equals("SUCCESS"));
		} catch (JMSException e) {
			e.printStackTrace();
			logger.error("请求加入队列失败： {}", e.getMessage());
		}*/
		
		/**发送消息对象*/
		try {
			OrderInfo info = new OrderInfo(new Random().nextInt(), message, new Random().nextFloat());
			String result = producerService.sendObjectQueueMessage(info);
			logger.info("IndexController ====> result: {}, isSuccess: {}", result, result.equals("SUCCESS"));
		} catch (JMSException e) {
			e.printStackTrace();
			logger.error("请求加入队列失败： {}", e.getMessage());
		}
	}
}
