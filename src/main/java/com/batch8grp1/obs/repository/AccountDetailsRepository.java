package com.batch8grp1.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch8grp1.obs.entity.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository <AccountDetails,String>{

	List<AccountDetails> findAll();
	AccountDetails findByAccountId(String accountId);
	
}
