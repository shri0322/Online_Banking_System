package com.batch8grp1.obs.payload.response;

public class AccountDetailsResponse {

	String accountId;
	String fullName;
	String createdAt;
	long balance;
	
	public AccountDetailsResponse(String accountId, String title, String firstName, String lastName, String createdAt, long balance) {
		super();
		this.accountId = accountId;
		this.fullName = title + " " + firstName + " " + lastName;
		this.createdAt = createdAt;
		this.balance = balance;
	}
	
	public String getFullName() {
		return fullName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
