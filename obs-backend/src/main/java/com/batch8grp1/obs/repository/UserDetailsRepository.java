package com.batch8grp1.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.batch8grp1.obs.entity.UserDetails;

@EnableJpaRepositories
@Repository
public interface UserDetailsRepository extends JpaRepository <UserDetails,String>{

		List<UserDetails> findAll();
		UserDetails findByUserId(String userId);
		UserDetails findByAccountId(String accountId);
}
