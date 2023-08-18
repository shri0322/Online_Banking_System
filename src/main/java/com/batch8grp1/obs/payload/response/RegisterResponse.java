package com.batch8grp1.obs.payload.response;

public class RegisterResponse {
	
	String netbankingId;
	String message;
	
	public String getNetbankingId() {
		return netbankingId;
	}

	public void setNetbankingId(String netbankingId) {
		this.netbankingId = netbankingId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RegisterResponse(String netbankingId, String message) {
		super();
		this.netbankingId = netbankingId;
		this.message = message;
	}
	
	

}
