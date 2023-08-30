package com.batch8grp1.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch8grp1.obs.entity.Transactions;

public interface TransactionsRepository extends JpaRepository <Transactions,String>{
	
	List<Transactions> findAll();
	
	Transactions findByTransactionId(String transactionId);
	
	List<Transactions> findByTxnType(String transactionType);
	
	List<Transactions> findByFromUserId(String fromUserId);
	
	List<Transactions> findByToUserId(String toUserId);
	
}
