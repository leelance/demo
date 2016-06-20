package com.lance.dubbo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lance.dubbo.modal.UserInfo;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Override
	public UserInfo findOne(int id) {
		return null;
	}

	@Override
	public List<UserInfo> findByAccount(String account) {
		return null;
	}

	@Override
	public void update(UserInfo info) {

	}

	@Override
	public void save(UserInfo info) {

	}
}