package com.lance.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.management.MBeanServerInvocationHandler;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class ConsumerService {
	Logger log = LogManager.getLogger(getClass());
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private ActiveMQQueue activeMQQueue;
	
	/**
	 * 接收到消息
	 * @param message
	 */
	public void receiveQueueMessage(){
		try {
			Message message = jmsTemplate.receive(activeMQQueue);
			log.info("message: {}", JSON.toJSONString(message));
			
			TextMessage textMessage = (TextMessage)message;
			log.info("textMessage: {}", textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 接收对象处理
	 */
	public void receiveQueueObjMessage(){
		Object obj = jmsTemplate.receiveAndConvert(activeMQQueue);
		log.info("obj message: {}", JSON.toJSONString(obj));
		
		OrderInfo info = (OrderInfo)obj;
		log.info("OrderInfo message: {}", JSON.toJSONString(info));
	}
}
