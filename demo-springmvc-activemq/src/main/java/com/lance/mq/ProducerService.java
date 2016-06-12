package com.lance.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class ProducerService {
	Logger log = LogManager.getLogger(getClass());
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private ActiveMQQueue activeMQQueue;
	
	/**
	 * 发送Text消息队列
	 * @param message
	 */
	public void sendTextQueueMessage(final String message) {
		jmsTemplate.send(activeMQQueue, new MessageCreator(){

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
	
	/**
	 * 发送消息并处理消息返回值
	 * @param message
	 */
	public void sendTextQueueMessageAndReceive(final String message) {
		Message tMessage = jmsTemplate.sendAndReceive(activeMQQueue, new MessageCreator(){

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
		
		log.info("sendTextAndReceive: {}", JSON.toJSONString(tMessage));
	}
	
	/**
	 * 订单入队列
	 * @param info
	 */
	public void sendObjectQueueMessage(final OrderInfo info) {
		jmsTemplate.convertAndSend(activeMQQueue, info);
	}
}