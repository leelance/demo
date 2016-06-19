package com.lance.dubbo.service;

import com.lance.dubbo.modal.UserAccountInfo;

public interface UserAccountService {
	/**
	 * 根据用户id获取账户信息
	 * @param userId
	 * @return
	 */
	UserAccountInfo findByUser(int userId);
	
	/**
	 * 新增账户信息
	 * @param account
	 * @return
	 */
	UserAccountInfo save(UserAccountInfo account);
	
	/**
	 * 更新账户信息
	 * @param account
	 */
	void update(UserAccountInfo account);
}
