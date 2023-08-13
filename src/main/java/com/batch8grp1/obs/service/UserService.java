package com.batch8grp1.obs.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.batch8grp1.obs.dto.UserDto;
import com.batch8grp1.obs.repository.UserRepository;

public interface UserService {

	String Register(UserDto userDto);

	String forgotUserId(String accountId, String otp);

	
	
	
	
	

}
