package com.batch8grp1.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch8grp1.obs.entity.UserDetails;

@Repository
public interface UserRepository extends JpaRepository <UserDetails,String>{

		List<UserDetails> findAll();
		UserDetails findByUserId(String userId);
		UserDetails findByAccountId(String accountId);
}
