package com.lance.bid.mapper;

import org.apache.ibatis.annotations.Insert;

import com.lance.bid.model.TenderInfo;

public interface TenderMapper {
	
	/**
	 * 插入数据
	 * @param info
	 */
	@Insert(value="insert into t_tender(tender_user, tender_total)values(#{tenderUser},#{tenderTotal})")
	void save(TenderInfo info);
}
