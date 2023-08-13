package com.batch8grp1.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch8grp1.obs.dto.LoginDto;
import com.batch8grp1.obs.dto.NetbankingDto;
import com.batch8grp1.obs.payload.response.LoginMessage;
import com.batch8grp1.obs.service.NetbankingService;

@RestController
@CrossOrigin
@RequestMapping("/netbanking")
public class NetbankingController {
	
	@Autowired private NetbankingService netbankingService;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginNetbanking(@RequestBody LoginDto loginDto)
	{
		LoginMessage loginResponse = netbankingService.loginNetbanking(loginDto);
		return ResponseEntity.ok(loginResponse);
		
	}
	
	@PostMapping("/signup")
	public String signUp(@RequestBody NetbankingDto netbankingDto)
	{
		String id=netbankingService.Signup(netbankingDto);
		String response = id + " Netbanking Signup Successful!";
		return response;
		
	}

}
