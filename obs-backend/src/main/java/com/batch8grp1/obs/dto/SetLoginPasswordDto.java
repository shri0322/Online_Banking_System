package com.batch8grp1.obs.dto;

public class SetLoginPasswordDto {
	
	
	private String netbankingId;
	private String newLoginPassword;

	
	public SetLoginPasswordDto() {}

	public SetLoginPasswordDto(String netbankingId, String newLoginPassword) {
		super();
		this.netbankingId = netbankingId;
		this.newLoginPassword = newLoginPassword;
		
	}

	public String getNetbankingId() {
		return netbankingId;
	}

	public void setNetbankingId(String netbankingId) {
		this.netbankingId = netbankingId;
	}

	
	public String getNewLoginPassword() {
		return newLoginPassword;
	}

	public void setNewLoginPassword(String newLoginPassword) {
		this.newLoginPassword = newLoginPassword;
	}

	
	

}
