package com.lance.bid.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BorrowInfo implements Serializable {
	private static final long serialVersionUID = 8055763267617515629L;

	private int id;
	/**借款用户*/
	private String borrowUserName;
	/**借款金额*/
	private BigDecimal borrowTotal;
	/**借款人收到投标人的金额*/
	private BigDecimal receiveTotal;
	/**借款用户Id*/
	private int borrowUserId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBorrowUserName() {
		return borrowUserName;
	}
	public void setBorrowUserName(String borrowUserName) {
		this.borrowUserName = borrowUserName;
	}
	public BigDecimal getBorrowTotal() {
		return borrowTotal;
	}
	public void setBorrowTotal(BigDecimal borrowTotal) {
		this.borrowTotal = borrowTotal;
	}
	public BigDecimal getReceiveTotal() {
		return receiveTotal;
	}
	public void setReceiveTotal(BigDecimal receiveTotal) {
		this.receiveTotal = receiveTotal;
	}
	public int getBorrowUserId() {
		return borrowUserId;
	}
	public void setBorrowUserId(int borrowUserId) {
		this.borrowUserId = borrowUserId;
	}
}