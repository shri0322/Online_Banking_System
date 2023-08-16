package com.batch8grp1.obs.dto;

public class SetLoginPasswordDto {
	
	private String accountId;
	private String newLoginPassword;
	private String confirmLoginPassword;
	
	public SetLoginPasswordDto() {}

	public SetLoginPasswordDto(String accountId, String newLoginPassword, String confirmLoginPassword) {
		super();
		this.accountId = accountId;
		this.newLoginPassword = newLoginPassword;
		this.confirmLoginPassword = confirmLoginPassword;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getNewLoginPassword() {
		return newLoginPassword;
	}

	public void setNewLoginPassword(String newLoginPassword) {
		this.newLoginPassword = newLoginPassword;
	}

	public String getConfirmLoginPassword() {
		return confirmLoginPassword;
	}

	public void setConfirmLoginPassword(String confirmLoginPassword) {
		this.confirmLoginPassword = confirmLoginPassword;
	}
	
	

}
