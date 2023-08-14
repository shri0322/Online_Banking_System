package com.batch8grp1.obs.dto;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NetbankingDto {

	@Autowired PasswordEncoder passwordEncoder;

	private String netbankingId;
	private String accountId;
	private String password;
	private String txnPassword;
	private String otp;
	
	//public NetbankingDto() {};
	
	public String setNetbankingId()
	{
		Random rand=new Random();
	    return Integer.toString(rand.nextInt(10000000));
	    
	}
	
	public NetbankingDto(String netbankingId,String accountId,String password,String txnPassword,String otp) {
		this.netbankingId=setNetbankingId();
		this.accountId=accountId;
		//this.password=setPassword(password);
		//this.txnPassword=setTxnPassword(txnPassword);
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

	public String setPassword(String password) {
		//this.password = passwordEncoder.encode(password);
		return this.password;
	}

	public String getTxnPassword() {
		return txnPassword;
	}

	public String setTxnPassword(String txnPassword) {
		//this.password = passwordEncoder.encode(txnPassword);
		return this.txnPassword;
	}

	public String getOtp() {
		return otp;
	}

}
