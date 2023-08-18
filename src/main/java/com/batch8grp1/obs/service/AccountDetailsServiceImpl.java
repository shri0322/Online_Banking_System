package com.batch8grp1.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.entity.UserDetails;
import com.batch8grp1.obs.payload.response.AccountDetailsResponse;
import com.batch8grp1.obs.repository.AccountDetailsRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService{
	
	@Autowired private AccountDetailsRepository accountdetailsRepository;
	@Autowired private UserDetailsRepository userdetailsRepository;
	
	public AccountDetailsResponse getAccountDetails(String accountId) {
		
		AccountDetails account=accountdetailsRepository.findByAccountId(accountId);
		UserDetails user=userdetailsRepository.findByAccountId(accountId);
		return new AccountDetailsResponse(account.getAccountId(),user.getTitle(),user.getFirstName(),user.getLastname(),account.getCreatedAt(),account.getBalance());
		
	}

}
