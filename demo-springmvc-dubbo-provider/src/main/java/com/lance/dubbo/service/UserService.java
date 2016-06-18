package com.lance.dubbo.service;

import java.util.List;

import com.lance.dubbo.modal.UserInfo;

public interface UserService {
	
	/**
	 * 根据ID查询用户对象
	 * @param id
	 * @return
	 */
	UserInfo findOne(int id);
	
	/**
	 * 根据账户查询用户列表
	 * @param account
	 * @return
	 */
	List<UserInfo>findByAccount(String account);
	
	/**
	 * 更新用户
	 * @param info
	 */
	void update(UserInfo info);
	
	/**
	 * 保存用户
	 * @param info
	 */
	void save(UserInfo info);
}
