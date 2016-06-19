package com.lance.dubbo.modal;

public class UserAccountInfo extends BaseInfo {
	private static final long serialVersionUID = 3022390598318849542L;

	/**用户ID*/
	private int userId;
	/**账户金额*/
	private double amount;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}