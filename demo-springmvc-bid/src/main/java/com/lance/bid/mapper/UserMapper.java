package com.lance.bid.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lance.bid.model.UserInfo;

public interface UserMapper {

	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	@Select(value="select *from t_user where id=#{id}")
	UserInfo findOne(int id);
	
	/**
	 * 插入数据
	 * @param info
	 */
	@Insert(value="insert into t_user(account, total, balance)values(#{account},#{total},#{balance})")
	void save(UserInfo info);
	
	/**
	 * 更新对象
	 * @param info
	 */
	@Update(value="update t_user set account=#{account},total=#{total},balance=#{balance} where id=#{id}")
	void update(UserInfo info);
}
