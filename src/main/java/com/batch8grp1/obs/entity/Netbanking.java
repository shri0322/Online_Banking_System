package com.batch8grp1.obs.entity;

import java.util.ArrayList;
import java.util.UUID;

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
		this.netbankingId=generateUniqueNumericString(10);
		this.accountId=accountId;
		this.password=password;
		this.txnPassword=txnPassword;
		this.otp=otp;
		
	}
	
	public Netbanking(String netbankingId2, String password2, ArrayList arrayList) {
		// TODO Auto-generated constructor stub
	}

	public static String generateUniqueNumericString(int length) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString().replaceAll("-", ""); 
        String numericString = uuidAsString.replaceAll("[^0-9]", "");
        if (numericString.length() < length) {
            numericString = String.format("%0" + length + "d", Long.parseLong(numericString));
        } else if (numericString.length() > length) {
            numericString = numericString.substring(0, length);
        }

        return numericString;
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
	
	public void setOtp(String otp)
	{
		this.otp=otp;
	}
}
