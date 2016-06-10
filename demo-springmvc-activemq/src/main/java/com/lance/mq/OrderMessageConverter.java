package com.lance.mq;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class OrderMessageConverter implements MessageConverter {

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		return session.createObjectMessage((Serializable)object);
	}

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		if(message instanceof ObjectMessage) {
			ObjectMessage objMessage = (ObjectMessage)message;
			return objMessage.getObject();
		}
		return null;
	}
}
