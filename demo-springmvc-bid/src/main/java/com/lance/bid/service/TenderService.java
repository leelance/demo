package com.lance.bid.service;

import java.math.BigDecimal;

import com.lance.bid.model.UserInfo;

public interface TenderService {

	/**
	 * 用户投标
	 * @param tenderUserId	投标用户id
	 * @param total			投标金额
	 * @param borrowId		投的标id
	 * @return
	 */
	String tender(int tenderUserId, BigDecimal total, int borrowId);
	
	/**
	 * 初始化用户
	 * @param info
	 */
	void initUser(UserInfo info);
}
