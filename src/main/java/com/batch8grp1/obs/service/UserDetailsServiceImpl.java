package com.batch8grp1.obs.service;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.SetLoginPasswordDto;
import com.batch8grp1.obs.dto.UserDetailsDto;
import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.entity.Netbanking;
import com.batch8grp1.obs.entity.UserDetails;
import com.batch8grp1.obs.payload.response.CreateAccountResponse;
import com.batch8grp1.obs.repository.AccountDetailsRepository;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired private UserDetailsRepository userDetailsRepository;
	@Autowired private NetbankingRepository netbankingRepository;
	@Autowired private AccountDetailsRepository accountDetailsRepository;
	
	public CreateAccountResponse createAccount(UserDetailsDto userDetailsDto)
	{
		
		UserDetails newuser=new UserDetails(userDetailsDto.getUserId(),userDetailsDto.getTitle(),userDetailsDto.getFirstName(),userDetailsDto.getLastName(),userDetailsDto.getFatherName(),userDetailsDto.getMobileNo(),userDetailsDto.getEmailId(),
						 userDetailsDto.getAadharNo(),userDetailsDto.getdOB(),userDetailsDto.getAddress(),userDetailsDto.getOccupationType(),userDetailsDto.getSourceOfIncome(),userDetailsDto.getGrossAnnualIncome(),userDetailsDto.getAccountId());
		
		userDetailsRepository.save(newuser);
		
		Netbanking newnetuser = new Netbanking("",newuser.getAccountId(),"","","");
		netbankingRepository.save(newnetuser);
		
		AccountDetails newaccount = new AccountDetails(newuser.getAccountId(),0,LocalDate.now().toString(),false);
		accountDetailsRepository.save(newaccount);
		
		return new CreateAccountResponse(newuser.getAccountId(),newuser.getTitle(),newuser.getFirstName(),newuser.getLastname());
		
	}
//	
//	public Netbanking loadUserbyUserId(String netbankingId) throws AccountNotFoundException
//	{
//		Netbanking user = netbankingRepository.findByNetbankingId(netbankingId);
//		return new Netbanking(user.getNetbankingId(),user.getPassword(),new ArrayList<>());
//	}

	@Override
	public String forgotUserId(String accountId, String otp) {
		String response="";
		Netbanking forgotUser=netbankingRepository.findByAccountId(accountId);
		if(forgotUser.getOtp().equals(otp))
		{
			response="User Verified. UserId sent to your registered email-id";
		}
		else response="User Unverified";
		
		return response;
	}
	
	public String forgotPassword(String userId, String otp)
	{
		String response="";
		UserDetails forgotPassword=userDetailsRepository.findByUserId(userId);
		Netbanking user=netbankingRepository.findByAccountId(forgotPassword.getAccountId());
		if(user.getOtp().equals(otp))
		{
			response="User Verified. You are been directed to set password page";
		}
		else response="User Unverified";
		
		return response;
		
	}
	
	public String setLoginPassword(SetLoginPasswordDto setLoginPasswordDto)
	{
		String response="";
		Netbanking user=netbankingRepository.findByAccountId(setLoginPasswordDto.getAccountId());
		if(setLoginPasswordDto.getNewLoginPassword().equals(setLoginPasswordDto.getConfirmLoginPassword()))
		{
			user.setPassword(setLoginPasswordDto.getNewLoginPassword());
			netbankingRepository.save(user);
			response ="New Password Set";
		}
		else response="Couldn't Set New Password";
		return response;
		
	}
	
//	@Override
//
//	public Netbanking loadUserByNetbankingId(String netbankingId) throws UsernameNotFoundException 
//	{
//		Netbanking loginuser = netbankingRepository.findByNetbankingId(netbankingId);
//		
//		return new org.springframework.security.core.userdetails.Netbanking(loginuser.getNetbankingId(),loginuser.getPassword(),new ArrayList<>());
//		//return new org.springframework.security.core.userdetails.Netbanking();
//		
//	}
//	
//	public String setLoginPassword(String accountId,String newLoginPassword, String confirmLoginPassword)
//	{
//		String response="";
//		Netbanking user=netbankingRepository.findByAccountId(accountId);
//		if(newLoginPassword.equals(confirmLoginPassword))
//		{
//			user.setPassword(newLoginPassword);
//			netbankingRepository.save(user);
//			response ="New Password Set";
//		}
//		else response="Couldn't Set New Password";
//		return response;
//		
//	}
}
