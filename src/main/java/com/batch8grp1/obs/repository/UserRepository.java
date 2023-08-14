package com.batch8grp1.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch8grp1.obs.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User,String>{

		List<User> findAll();
		User findByUserId(String userId);
		User findByAccountId(String accountId);
}
