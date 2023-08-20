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
import com.batch8grp1.obs.payload.response.RegisterResponse;
import com.batch8grp1.obs.service.NetbankingService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/netbanking")
public class NetbankingController {
	
	@Autowired private NetbankingService netbankingService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> loginNetbanking(@RequestBody LoginDto loginDto)
	{
		LoginMessage loginResponse = netbankingService.loginNetbanking(loginDto);
		return ResponseEntity.ok(loginResponse);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody NetbankingDto netbankingDto)
	{
		RegisterResponse id=netbankingService.register(netbankingDto);
		return ResponseEntity.ok(id);
		
	}

}
