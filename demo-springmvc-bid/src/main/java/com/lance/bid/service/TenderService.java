package com.lance.bid.service;

import java.math.BigDecimal;

public interface TenderService {

	/**
	 * 用户投标
	 * @param tenderUserId	投标用户id
	 * @param total			投标金额
	 * @param borrowId		投的标id
	 * @return
	 */
	String tender(int tenderUserId, BigDecimal total, int borrowId);
}
