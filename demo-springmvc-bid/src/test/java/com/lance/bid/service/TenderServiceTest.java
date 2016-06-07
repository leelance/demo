package com.lance.bid.service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lance.bid.model.UserInfo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class TenderServiceTest extends AbstractJUnit4SpringContextTests{
	Logger log = LogManager.getLogger();
	/**设置默认标id*/
	public static final int BORROW_ID = 1;
	@Autowired
	private TenderService tenderService;
	@Autowired
	private JedisPool jedisPool;

	@Test
	public void tender() {
		//设置标的已投标金额
		Jedis jedis = jedisPool.getResource();
		jedis.set(TenderServiceImpl.BORROW_KEY, "0");
		
		log.info(".........Tender start........");
		ExecutorService executor = Executors.newFixedThreadPool(20);
		Job job1 = new Job(7, 1000);
		Job job2 = new Job(1001, 2000);
		Job job3 = new Job(2001, 3000);
		Job job4 = new Job(3001, 4000);
		Job job5 = new Job(4001, 5000);
		
		Future<String>result1 = executor.submit(job1);
		Future<String>result2 = executor.submit(job2);
		Future<String>result3 = executor.submit(job3);
		Future<String>result4 = executor.submit(job4);
		Future<String>result5 = executor.submit(job5);
		
		try {
			log.info("result1: {}", result1.get());
			log.info("result2: {}", result2.get());
			log.info("result3: {}", result3.get());
			log.info("result4: {}", result4.get());
			log.info("result5: {}", result5.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally {
			executor.shutdown();
		}
		
		log.info("投标后金额Borrow_1： {}", jedis.get(TenderServiceImpl.BORROW_KEY));
		jedis.close();
	}
	
	/**
	 * 初始化投标用户
	 */
	@Before
	@Ignore
	public void initUser() {
		log.info("........init user.........");
		BigDecimal balance = BigDecimal.valueOf(20000);
		UserInfo info = null;
		for(int i=7; i<=5000; i++) {
			info = new UserInfo("tender"+i, balance, balance);
			tenderService.initUser(info);
		}
		log.info("........init end.........");
	}
	
	//执行Job
	class Job implements Callable<String> {
		private int start;
		private int len;
		
		public Job(int start, int len){
			this.start = start;
			this.len = len;
		}

		@Override
		public String call() throws Exception {
			for(int i=start; i<=len; i++) {
				//随机投标金额
				int val = new Random().nextInt(1000);
				//int val = 1000;
				String result = tenderService.tender(i, BigDecimal.valueOf(val), BORROW_ID);
				
				log.info("tender: {}, 投标返回： {}", "tender"+i, result);
				if(StringUtils.equals(result, "0")) {
					return "投标成功";
				}
			}
			return null;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getLen() {
			return len;
		}

		public void setLen(int len) {
			this.len = len;
		}
	}
}