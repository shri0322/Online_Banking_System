package com.batch8grp1.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.UserDto;
import com.batch8grp1.obs.entity.Netbanking;
import com.batch8grp1.obs.entity.User;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserRepository userRepository;
	@Autowired private NetbankingRepository netbankingRepository;
	
	public String Register(UserDto userDto)
	{
		
		User newuser=new User(userDto.getUserId(),userDto.getTitle(),userDto.getFirstName(),userDto.getLastname(),userDto.getFatherName(),userDto.getMobileNo(),userDto.getEmailId(),
						 userDto.getAadharNo(),userDto.getdOB(),userDto.getAddress(),userDto.getOccupationType(),userDto.getSourceofIncome(),userDto.getGrossAnnualIncome(),userDto.getAccountId());
		
		userRepository.save(newuser);
		return "User Registered";
		
	}

	@Override
	public String forgotUserId(String accountId, String otp) {
		String response="";
		Netbanking forgotUser=netbankingRepository.findByAccountId(accountId);
		if(forgotUser.getOtp().equals(otp))
		{
			response="User Verified";
		}
		else response="User Unverified";
		
		return response;
	}
}
