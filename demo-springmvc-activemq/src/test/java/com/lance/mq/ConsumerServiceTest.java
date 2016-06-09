package com.lance.mq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/applicationContext.xml")
public class ConsumerServiceTest extends AbstractJUnit4SpringContextTests {
	Logger log = LogManager.getLogger(getClass());
	@Autowired
	private ConsumerService consumerService;
	
	/**
	 * 测试接收消息队列消息
	 */
	@Test
	public void receiveMessage() {
		consumerService.receiveQueueMessage();
	}
}
