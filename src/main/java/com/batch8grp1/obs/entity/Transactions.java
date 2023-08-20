package com.batch8grp1.obs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name="Transactions")
public class Transactions {
	
	@Id
	@Column(name="TransactionId")
	private String transactionId;
	
	@Column(name="TransactionType")
	private String transactionType;
	
	@Column(name="InitiatedAt")
	private String initiatedAt;
	
	@Column(name="CompletedAt")
	private String completedAt;

	@Column(name="FromUserId")
	private String fromUserId;

	@Column(name="ToUserId")
	private String toUserId;
	
	@Column(name="Amount")
	private long amount;
	
	@Column(name="Remarks")
	private String remarks;
	
	@Column(name="isCredited")
	private boolean isCredited;
	
	public Transactions() {}

	public Transactions(String transactionId, String transactionType, String initiatedAt, String completedAt,
			String fromUserId, String toUserId, long amount, String remarks, boolean isCredited) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.initiatedAt = initiatedAt;
		this.completedAt = completedAt;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		this.amount = amount;
		this.remarks = remarks;
		this.isCredited = isCredited;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public boolean isCredited() {
		return isCredited;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public String getInitiatedAt() {
		return initiatedAt;
	}

	public String getCompletedAt() {
		return completedAt;
	}

	public long getAmount() {
		return amount;
	}

	public String getRemarks() {
		return remarks;
	}

	
	
	
}
