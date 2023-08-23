package com.batch8grp1.obs.dto;

public class TransferRequestDto {
	
	private String fromUserId;
	private String toUserId;
	private long amount;
	private String txnType;
	private String remarks;
	
	public TransferRequestDto() {} 
	
	public TransferRequestDto(String fromUserId, String toUserId, long amount, String txnType, String remarks) {
		super();
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		this.amount = amount;
		this.txnType = txnType;
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	
	

}
