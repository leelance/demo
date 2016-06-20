package com.lance.dubbo.service;

import org.springframework.stereotype.Service;

import com.lance.dubbo.modal.UserAccountInfo;

@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService{

	@Override
	public UserAccountInfo findByUser(int userId) {
		return null;
	}

	@Override
	public UserAccountInfo save(UserAccountInfo account) {
		return null;
	}

	@Override
	public void update(UserAccountInfo account) {
		
	}
}