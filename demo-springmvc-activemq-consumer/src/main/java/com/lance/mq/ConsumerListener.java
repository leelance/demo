package com.lance.mq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener{
	Logger log = LogManager.getLogger(getClass());
	
	public void handleMessage(String message) {
		log.info("Message: {}", message);
	}
	
	/*void handleMessage(Map message);
    void handleMessage(byte[] message);
    void handleMessage(Serializable message);*/
}