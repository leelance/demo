package com.lance.mq;

import java.util.Random;

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
public class ProducerServiceTest extends AbstractJUnit4SpringContextTests{
	Logger log = LogManager.getLogger(getClass());
	@Autowired
	private ProducerService producerService;

	@Test
	public void sendText(){
		String message = "Hello Queue Message.";
		producerService.sendTextQueueMessage(message);
	}
	
	/**
	 * 测试多个订单
	 */
	//@Test
	public void sendObject(){
		OrderInfo info = null;
		info = new OrderInfo((1 + new Random().nextInt(1000)), "Iphone", 5000);
		producerService.sendObjectQueueMessage(info);
		/*for(int i=1; i<100; i++) {
			info = new OrderInfo((i + new Random().nextInt(1000)), "Iphone", 5000);
			producerService.sendObjectQueueMessage(info);
		}*/
	}
}
