package com.batch8grp1.obs.payload.response;

public class CreateAccountResponse {

	String accountId;
	String fullName;
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public CreateAccountResponse(String accountId, String title, String firstName, String lastName) {
		this.accountId = accountId;
		this.fullName = title + " " + firstName + " " + lastName;
	}
	
	
}
