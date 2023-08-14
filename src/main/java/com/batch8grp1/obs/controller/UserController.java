package com.batch8grp1.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch8grp1.obs.dto.UserDto;
import com.batch8grp1.obs.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> Register(@RequestBody UserDto userDto) 
	
	{
		String response=userService.Register(userDto);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/forgotuserid")
	public ResponseEntity<?> forgotUserId(@RequestBody String AccountId, String otp) 
	
	{
		String response=userService.forgotUserId(AccountId,otp);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/forgotpassword")
	public ResponseEntity<?> forgotPassword(@RequestBody String userId, String otp)
	{
		String response=userService.forgotPassword(userId,otp);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/setloginpassword")
	public ResponseEntity<?> setLoginPassword(@RequestBody String accountId, String newLoginPassword, String confirmLoginPassword)
	{
		String response=userService.setLoginPassword(accountId,newLoginPassword,confirmLoginPassword);
		return ResponseEntity.ok(response);
	}
	
	

}
