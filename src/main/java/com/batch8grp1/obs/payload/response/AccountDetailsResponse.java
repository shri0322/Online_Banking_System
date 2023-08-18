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
	
	

}
