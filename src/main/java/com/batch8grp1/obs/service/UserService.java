package com.batch8grp1.obs.service;

import com.batch8grp1.obs.dto.UserDto;

public interface UserService {

	String Register(UserDto userDto);
	String forgotUserId(String accountId, String otp);
	String forgotPassword(String userId, String otp);
	String setLoginPassword(String accountId, String newLoginPassword, String confirmLoginPassword);

}
