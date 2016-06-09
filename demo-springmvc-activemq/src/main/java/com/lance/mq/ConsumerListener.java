package com.lance.mq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsumerListener {
	Logger log = LogManager.getLogger(getClass());

	public String receiveMessage(String message) {
		log.info("ConsumerListener message: {}", message);
		return message;
	}
}
