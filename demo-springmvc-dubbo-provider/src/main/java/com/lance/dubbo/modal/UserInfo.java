package com.lance.dubbo.modal;

public class UserInfo extends BaseInfo{
	private static final long serialVersionUID = -4292938610966260307L;

	/**Account*/
	private String account;
	
	/**Password*/
	private String password;
	
	/**Name*/
	private String name;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}