package com.lance.bid.service;

import java.math.BigDecimal;

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

import com.lance.bid.mapper.BorrowMapper;
import com.lance.bid.model.BorrowInfo;
import com.lance.bid.model.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class TenderServiceTest extends AbstractJUnit4SpringContextTests{
	Logger log = LogManager.getLogger();
	@Autowired
	private TenderService tenderService;
	@Autowired
	private BorrowMapper borrowMapper;

	@Test
	public void tender() {
		log.info(".........Tender start........");
		BorrowInfo borrow = borrowMapper.findOne(1);
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
}
