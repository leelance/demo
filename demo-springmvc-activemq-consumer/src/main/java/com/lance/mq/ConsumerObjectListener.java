package com.lance.mq;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSON;

public class ConsumerObjectListener implements SessionAwareMessageListener<ObjectMessage>{
	Logger logger = LogManager.getLogger(getClass());

	@Override
	public void onMessage(ObjectMessage message, Session session) throws JMSException {
		long startTime = System.currentTimeMillis();
		logger.info("Message: {}", JSON.toJSONString(message));
		
		Object obj = message.getObject();
		OrderInfo info = (OrderInfo)obj;
		logger.info("OrderInfo: {}", JSON.toJSONString(info));
		
		//测试事务回滚
		if(info.getGoodsId() % 2 == 0) {
			throw new RuntimeException("订单抛异常了, 事务要回滚了");
		}
		
		//返回收到消息后通知
		MessageProducer producer = session.createProducer(null);
		TextMessage replyMessage = session.createTextMessage();
		replyMessage.setText("SUCCESS");
		replyMessage.setJMSCorrelationID(message.getJMSCorrelationID());
		producer.send(message.getJMSReplyTo(), replyMessage);
		
		logger.info("ConsumerReturnListener =====> receiveMsg: {}, replyMsg： {}", info.getGoods(), replyMessage.getText());
		logger.info("TimeOut: {}", (System.currentTimeMillis() - startTime));
	}
}