package com.lance.mq;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSON;

public class ConsumerReturnListener implements SessionAwareMessageListener<TextMessage> {
	Logger logger = LogManager.getLogger();

	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
		long startTime = System.currentTimeMillis();
		logger.info("message: {}", JSON.toJSONString(message));
		
		//返回收到消息后通知
		MessageProducer producer = session.createProducer(null);
		TextMessage replyMessage = session.createTextMessage();
		replyMessage.setText("SUCCESS");
		replyMessage.setJMSCorrelationID(message.getJMSCorrelationID());
		producer.send(message.getJMSReplyTo(), replyMessage);
		
		logger.info("ConsumerReturnListener =====> receiveMsg: {}, replyMsg", message.getText(), replyMessage.getText());
		logger.info("TimeOut: {}", (System.currentTimeMillis() - startTime));
	}
}
