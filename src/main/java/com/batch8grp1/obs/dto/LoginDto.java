package com.batch8grp1.obs.dto;

public class LoginDto {
	
	private String netbankingId;
	private String password;
	
	public LoginDto() {}

	public LoginDto(String netbankingId, String password)
	{
		this.netbankingId=netbankingId;
		this.password=password;
	}

	
	public String getNetbankingId() {
		return netbankingId;
	}

	public void setNetbankingId(String netbankingId) {
		this.netbankingId = netbankingId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
