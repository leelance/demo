package com.lance.dubbo.modal;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseInfo implements Serializable{
	private static final long serialVersionUID = 8591408516313368261L;
	
	private int id;
	
	private Date createTime;
	
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}