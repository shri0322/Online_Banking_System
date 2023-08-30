package com.batch8grp1.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.batch8grp1.obs.entity.AccountDetails;

@EnableJpaRepositories
@Repository
public interface AccountDetailsRepository extends JpaRepository <AccountDetails,String>{

	List<AccountDetails> findAll();
	AccountDetails findByAccountId(String accountId);
	
}
