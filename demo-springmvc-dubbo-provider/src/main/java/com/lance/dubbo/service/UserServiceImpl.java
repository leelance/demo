package com.lance.dubbo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lance.dubbo.modal.UserInfo;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public UserInfo findOne(int id) {
		UserInfo info = new UserInfo();
		info.setId(1);
		info.setAccount("Klay");
		info.setCreateTime(new Date());
		info.setName("Klay Rooney");
		info.setPassword("123456");
		info.setUpdateTime(new Date());
		return info;
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