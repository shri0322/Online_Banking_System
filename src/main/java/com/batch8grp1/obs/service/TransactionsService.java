package com.batch8grp1.obs.service;

import java.util.List;

import com.batch8grp1.obs.entity.Transactions;

public interface TransactionsService {
	
	List<Transactions> getAllTransactions();
	List<Transactions> getTxnOfFromUserId(String fromUserId);
	Transactions getTxn(String transactionId);
	List<Transactions> getTxnOfType(String transactionType);
}
