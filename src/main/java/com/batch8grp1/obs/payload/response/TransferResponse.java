package com.batch8grp1.obs.payload.response;

import com.batch8grp1.obs.entity.Transactions;

public class TransferResponse {
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private Transactions txn;
	private String message;
	
	
	public TransferResponse() {}
	
	public TransferResponse(Transactions txn,String msg)
	{
		super();
		this.txn = txn;
		this.message = msg;
	}

	public Transactions getTxn() {
		return txn;
	}

	public void setTxn(Transactions txn) {
		this.txn = txn;
	}



}
