package com.batch8grp1.obs.dto;

public class UpdateAccountStatusDto {
	




	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public String getIsApproved() {
		return isApproved;
	}



	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}



	String accountId;
	String isApproved;
	
	
	
	public UpdateAccountStatusDto() {
		super();
	}



	public UpdateAccountStatusDto(String accountId, String isApproved) {
		super();
		this.accountId = accountId;
		this.isApproved = isApproved;
	}
	
	

}
