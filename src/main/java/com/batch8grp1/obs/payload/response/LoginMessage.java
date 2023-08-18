package com.batch8grp1.obs.payload.response;

public class LoginMessage {
	
	String netbankingId;
	String fullName;
	String message;
	
	public LoginMessage(String netbankingId, String title, String firstName, String lastName, String message) {
		super();
		this.netbankingId = netbankingId;
		this.fullName = title + " " + firstName + " " + lastName;
		this.message = message;
	}
	public String getNetbankingId() {
		return netbankingId;
	}
	public void setNetbankingId(String netbankingId) {
		this.netbankingId = netbankingId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
