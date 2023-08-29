package com.batch8grp1.obs.dto;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.batch8grp1.obs.repository.NetbankingRepository;

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
	
	public NetbankingDto() {};
	
	public NetbankingDto(String accountId,String password,String txnPassword,String otp) {
		this.accountId=accountId;
		this.password=setPassword(password);
		this.txnPassword=setTxnPassword(txnPassword);
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
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		//this.password = passwordEncoder.encode(password);
		return encodedPassword;
	}

	public String getTxnPassword() {
		return txnPassword;
	}

	public String setTxnPassword(String txnPassword) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(txnPassword);
		//this.password = passwordEncoder.encode(txnPassword);
		return encodedPassword;
	}

	public String getOtp() {
		return otp;
	}

}
