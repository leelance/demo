package com.lance.shiro.service;

import java.util.Set;

import com.lance.shiro.model.UserInfo;

public interface UserService {
	
	/**
	 * 根据账号Account查询当前用户
	 * @param account
	 * @return
	 */
	UserInfo findByAccount(String account);
	
	/**
	 * 获取资源集合
	 * @param account
	 * @return
	 */
	Set<String> findPermissions(String account);
}
