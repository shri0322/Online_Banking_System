package com.batch8grp1.obs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="Netbanking")
public class Netbanking {
	
	
	@Id
	@Column(name="NetbankingId",nullable=true)
	private String netbankingId;
	
	@Column(name="AccountId",nullable=false)
	private String accountId;
	
	@Column(name="Password",nullable=true)
	private String password;
	
	@Column(name="TxnPassword",nullable=true)
	private String txnPassword;
	
	@Column(name="Otp",nullable=true)
	private String otp;
	
	private String otpRequestTime;
	
	public Netbanking() {};
	
	public Netbanking(String netbankingId, String accountId,String password,String txnPassword,String otp) {
		this.netbankingId=netbankingId;
		this.accountId=accountId;
		this.password=password;
		this.txnPassword=txnPassword;
		this.otp=otp;
		
	}
	
	
	
	public String getNetbankingId() {
		return netbankingId;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTxnPassword() {
		return txnPassword;
	}
	
	public void setTxnPassword(String txnPassword) {
		this.txnPassword = txnPassword;
	}

	public String getOtp() {
		return otp;
	}
}
