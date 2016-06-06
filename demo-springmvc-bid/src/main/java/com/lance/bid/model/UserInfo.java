package com.lance.bid.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = -7974653483805077261L;
	
	private int id;
	private String account;
	private BigDecimal total;
	private BigDecimal balance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}