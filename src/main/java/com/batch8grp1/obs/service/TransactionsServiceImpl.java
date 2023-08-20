package com.batch8grp1.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.repository.TransactionsRepository;

@Service
public class TransactionsServiceImpl implements TransactionsService{

	@Autowired private TransactionsRepository txnRepository;
	
	public List<Transactions> getAllTransactions()
	{
		List<Transactions> allTxns = txnRepository.findAll();
		return allTxns;
	}
	
	public List<Transactions> getTxnOfFromUserId(String fromUserId)
	{
		
		List<Transactions> txnfromuser = txnRepository.findByFromUserId(fromUserId);
		return txnfromuser;
		
	}
	
	public Transactions getTxn(String transactionId)
	{
		Transactions txn = txnRepository.findByTransactionId(transactionId);
		return txn;
	}

	public List<Transactions> getTxnOfType(String transactionType)
	{
		
		List<Transactions> txntype = txnRepository.findByTransactionType(transactionType);
		return txntype;
		
	}
	
	
	
	
}
