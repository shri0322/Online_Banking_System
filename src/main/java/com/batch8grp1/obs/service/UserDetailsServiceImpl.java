package com.batch8grp1.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.SetLoginPasswordDto;
import com.batch8grp1.obs.dto.UserDetailsDto;
import com.batch8grp1.obs.entity.Netbanking;
import com.batch8grp1.obs.entity.UserDetails;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired private UserRepository userRepository;
	@Autowired private NetbankingRepository netbankingRepository;
	
	public String Register(UserDetailsDto userDetailsDto)
	{
		
		UserDetails newuser=new UserDetails(userDetailsDto.getUserId(),userDetailsDto.getTitle(),userDetailsDto.getFirstName(),userDetailsDto.getLastName(),userDetailsDto.getFatherName(),userDetailsDto.getMobileNo(),userDetailsDto.getEmailId(),
						 userDetailsDto.getAadharNo(),userDetailsDto.getdOB(),userDetailsDto.getAddress(),userDetailsDto.getOccupationType(),userDetailsDto.getSourceOfIncome(),userDetailsDto.getGrossAnnualIncome(),userDetailsDto.getAccountId());
		
		
		userRepository.save(newuser);
		String response=newuser.getAccountId() +"," + newuser.getTitle() + " " + newuser.getFirstName() + " "+ newuser.getLastname();
		return response;
		
	}

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
		UserDetails forgotPassword=userRepository.findByUserId(userId);
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
