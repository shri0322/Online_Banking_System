package com.batch8grp1.obs.dto;

public class TxnPasswordDto {

	private String netbankingId;
	private String newTxnPassword;
	
	public TxnPasswordDto() {
		super();
	}

	public TxnPasswordDto(String netbankingId, String newTxnPassword) {
		super();
		this.netbankingId = netbankingId;
		this.newTxnPassword = newTxnPassword;

	}
	
	public String getNetbankingId() {
		return netbankingId;
	}

	public void setNetbankingId(String netbankingId) {
		this.netbankingId = netbankingId;
	}
	
	

	public String getNewTxnPassword() {
		return newTxnPassword;
	}

	public void setNewTxnPassword(String newTxnPassword) {
		this.newTxnPassword = newTxnPassword;
	}

	

}
