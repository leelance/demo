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
public class ProducerServiceTest extends AbstractJUnit4SpringContextTests{
	Logger log = LogManager.getLogger(getClass());
	@Autowired
	private ProducerService producerService;

	@Test
	public void send(){
		String message = "Hello Queue Message.";
		producerService.sendTextQueueMessage(message);
	}
}
