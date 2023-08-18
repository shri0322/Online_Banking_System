package com.batch8grp1.obs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.*;

@Getter
@Setter
@Entity
@Table(name="AccountDetails")
public class AccountDetails {
	
	@Id
	@Column(name="AccountId",nullable=false)
	private String accountId;
	
	@Column(name="Balance",nullable=true)
	private long balance;
	
	@Column(name="CreatedAt",nullable=true)
	private String createdAt;
	
	@Column(name="isApproved",nullable=true)
	private boolean isApproved;

	public AccountDetails() {}

	public AccountDetails(String accountId, long balance, String createdAt, boolean isApproved) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.createdAt = createdAt;
		this.isApproved = isApproved;
	}

	public String getAccountId() {
		return accountId;
	}

	public long getBalance() {
		return balance;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public boolean isApproved() {
		return isApproved;
	}
	
	
}