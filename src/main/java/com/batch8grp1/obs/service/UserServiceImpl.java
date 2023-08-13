package com.batch8grp1.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.UserDto;
import com.batch8grp1.obs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserRepository userRepository;
	
	public String Register(UserDto userDto)
	{
		
		//User newuser=new User(userDto.)
		return null;
		
	}

	@Override
	public String forgotUserId(String accountId, String otp) {
		// TODO Auto-generated method stub
		return null;
	}
}
