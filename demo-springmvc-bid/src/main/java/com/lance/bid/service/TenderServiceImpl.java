package com.lance.bid.service;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lance.bid.mapper.BorrowMapper;
import com.lance.bid.mapper.TenderMapper;
import com.lance.bid.mapper.UserMapper;
import com.lance.bid.model.BorrowInfo;
import com.lance.bid.model.TenderInfo;
import com.lance.bid.model.UserInfo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class TenderServiceImpl implements TenderService {
	Logger log = LogManager.getLogger(getClass());
	/** 最小投标金额 */
	public static final int MIN_TENDER_TOTAL = 100;
	/**标在Redis中的key*/
	public static final String BORROW_KEY = "Borrow_1";
	@Autowired
	private BorrowMapper borrowMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TenderMapper tenderMapper;
	@Autowired
	private JedisPool jedisPool;

	/**
	 * 用户投标
	 * 
	 * @param tenderUserId
	 *            投标用户id
	 * @param total
	 *            投标金额
	 * @param borrowId
	 *            投的标id
	 * @return
	 */
	@Transactional
	public String tender(int tenderUserId, BigDecimal total, int borrowId) {
		Jedis jedis = jedisPool.getResource();
		try {
			BorrowInfo borrow = borrowMapper.findOne(borrowId);
			borrow.setBorrowTotal(borrow.getBorrowTotal().add(total));
			BigDecimal receiveTotal = BigDecimal.valueOf(jedis.incrByFloat(BORROW_KEY, total.doubleValue()));
			// 标已经投满
			if (borrow.getBorrowTotal().intValue() <= receiveTotal.intValue()) {
				jedis.incrByFloat(BORROW_KEY, 0 - total.doubleValue());
				return "0";
			}

			// 剩余金额
			BigDecimal remainTotal = borrow.getBorrowTotal().subtract(receiveTotal);
			if (remainTotal.intValue() < total.intValue()) {
				jedis.incrByFloat(BORROW_KEY, 0 - total.doubleValue());
				return String.format("您投标后所剩余金额不能小于最小金额：%s, 您投标金额为：%s, 已投金额：%s", remainTotal.intValue(), total.intValue(),
						borrow.getReceiveTotal().intValue());
			}

			// 判断投标人余额是否够
			UserInfo tenderUser = userMapper.findOne(tenderUserId);
			if (tenderUser.getBalance().intValue() < total.intValue()) {
				jedis.incrByFloat(BORROW_KEY, 0 - total.doubleValue());
				return String.format("您的余额不足，账户余额为：%s, 您投标金额为：%s", tenderUser.getBalance().intValue(), total.intValue());
			}

			// 更新标的投标金额
			int row = borrowMapper.updateReceiveTotal(total, borrowId);
			if (row == 0) {
				jedis.incrByFloat(BORROW_KEY, 0 - total.doubleValue());
				return "投标失败";
			}

			// 插入投标记录
			TenderInfo tender = new TenderInfo(tenderUser.getAccount(), total);
			tenderMapper.save(tender);

			// 更新余额
			tenderUser.setBalance(tenderUser.getBalance().subtract(total));
			userMapper.update(tenderUser);
		} finally{
			jedis.close();
		}
		return null;
	}

	/**
	 * 初始化用户
	 * 
	 * @param info
	 */
	@Transactional
	public void initUser(UserInfo info) {
		userMapper.save(info);
	}
}