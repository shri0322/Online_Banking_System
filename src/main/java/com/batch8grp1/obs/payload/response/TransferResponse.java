package com.batch8grp1.obs.payload.response;

import com.batch8grp1.obs.entity.Transactions;

public class TransferResponse {
	
	private Transactions txn;
	private String msg;
	
	
	public TransferResponse() {}
	
	public TransferResponse(Transactions txn,String msg)
	{
		super();
		this.txn = txn;
		this.msg = msg;
	}

	public Transactions getTxn() {
		return txn;
	}

	public void setTxn(Transactions txn) {
		this.txn = txn;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
