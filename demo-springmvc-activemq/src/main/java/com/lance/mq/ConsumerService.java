package com.lance.mq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {
	Logger log = LogManager.getLogger(getClass());
	
	/**
	 * 接收到消息
	 * @param message
	 */
	public void receiveMessage(String message){
		log.info("receiveMessage: {}", message);
	}
}
