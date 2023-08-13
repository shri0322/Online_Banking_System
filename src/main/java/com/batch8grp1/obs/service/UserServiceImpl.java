package com.batch8grp1.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.UserDto;
import com.batch8grp1.obs.entity.User;
import com.batch8grp1.obs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserRepository userRepository;
	
	public String Register(UserDto userDto)
	{
		
		User newuser=new User(userDto.getTitle(),userDto.getFirstName(),userDto.getLastname(),userDto.getFatherName(),userDto.getMobileNo(),userDto.getEmailId(),
						 userDto.getAadharNo(),userDto.getdOB(),userDto.getAddress(),userDto.getOccupationType(),userDto.getSourceofIncome(),userDto.getGrossAnnualIncome());
		
		userRepository.save(newuser);
		return "User Registered";
		
	}

	@Override
	public String forgotUserId(String accountId, String otp) {
		
		return null;
	}
}
