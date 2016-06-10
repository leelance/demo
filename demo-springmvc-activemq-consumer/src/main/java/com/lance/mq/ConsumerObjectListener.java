package com.lance.mq;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSON;

public class ConsumerObjectListener implements SessionAwareMessageListener<ObjectMessage>{
	Logger log = LogManager.getLogger(getClass());

	@Override
	public void onMessage(ObjectMessage message, Session session) throws JMSException {
		log.info("Message: {}", JSON.toJSONString(message));
		
		Object obj = message.getObject();
		OrderInfo info = (OrderInfo)obj;
		log.info("OrderInfo: {}", JSON.toJSONString(info));
		
	}
}