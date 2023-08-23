package com.batch8grp1.obs.service;

import java.util.List;

import com.batch8grp1.obs.dto.TransferRequestDto;
import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.payload.response.TransferResponse;

public interface TransactionsService {
	
	List<Transactions> getAllTransactions();
	List<Transactions> getTxnOfFromUserId(String netbankingId);
	Transactions getTxn(String transactionId);
	List<Transactions> getTxnOfType(String transactionType);
	TransferResponse transfer(TransferRequestDto transferRequestDto);

}
