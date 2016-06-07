package com.lance.bid.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TenderInfo implements Serializable {
	private static final long serialVersionUID = 5547286706350597122L;
	private int id;
	/**投标用户*/
	private String tenderUser;
	/**投标金额*/
	private BigDecimal tenderTotal;
	
	public TenderInfo() {
		
	}
	
	public TenderInfo(String tenderUser, BigDecimal tenderTotal) {
		this.tenderUser = tenderUser;
		this.tenderTotal = tenderTotal;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenderUser() {
		return tenderUser;
	}
	public void setTenderUser(String tenderUser) {
		this.tenderUser = tenderUser;
	}
	public BigDecimal getTenderTotal() {
		return tenderTotal;
	}
	public void setTenderTotal(BigDecimal tenderTotal) {
		this.tenderTotal = tenderTotal;
	}
}