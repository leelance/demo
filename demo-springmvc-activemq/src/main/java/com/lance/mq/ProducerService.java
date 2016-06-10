package com.lance.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {
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
	 * 订单入队列
	 * @param info
	 */
	public void sendObjectQueueMessage(final OrderInfo info) {
		jmsTemplate.convertAndSend(activeMQQueue, info);
	}
}