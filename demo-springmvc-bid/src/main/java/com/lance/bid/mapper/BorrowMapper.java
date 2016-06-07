package com.lance.bid.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lance.bid.model.BorrowInfo;

public interface BorrowMapper {

	/**
	 * 更新收到金额
	 * @param total
	 * @param id
	 */
	@Update(value="update t_borrow set receive_total + #{total} where (borrow_total-receive_total) >= #{total} and id=#{id}")
	void updateReceiveTotal(BigDecimal total, int id);
	
	/**
	 * 查询标记录
	 * @param id
	 * @return
	 */
	@Select("select *from t_borrow where id=#{id}")
	BorrowInfo findOne(int id);
}
