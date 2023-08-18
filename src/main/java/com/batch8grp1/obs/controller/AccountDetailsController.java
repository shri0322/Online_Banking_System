package com.batch8grp1.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch8grp1.obs.payload.response.AccountDetailsResponse;
import com.batch8grp1.obs.payload.response.LoginMessage;
import com.batch8grp1.obs.service.AccountDetailsService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/account")
public class AccountDetailsController {
	
	@Autowired private AccountDetailsService accountdetailsService;
	
	@PostMapping("/getdetails")
	public ResponseEntity<?> getAccountDetails(@RequestParam String accountId)
	{
		AccountDetailsResponse accountResponse = accountdetailsService.getAccountDetails(accountId);
		return ResponseEntity.ok(accountResponse);		
	}

}
