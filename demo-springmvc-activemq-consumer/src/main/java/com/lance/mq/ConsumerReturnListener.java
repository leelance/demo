package com.lance.mq;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSON;

/**
 * 实现SessionAwareMessageListener接口, 监听消息队列, 并通知消息收到成功
 * @author Administrator
 *
 */
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
