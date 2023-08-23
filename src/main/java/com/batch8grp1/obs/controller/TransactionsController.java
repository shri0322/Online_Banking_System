package com.batch8grp1.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch8grp1.obs.dto.TransferRequestDto;
import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.payload.response.TransferResponse;
import com.batch8grp1.obs.service.TransactionsService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/transactions")
public class TransactionsController {
	
	@Autowired private TransactionsService txnService;
	
	@GetMapping("/alltxns")
	public ResponseEntity<?> allTxns()
	{
		List<Transactions> alltxns = txnService.getAllTransactions();
		return ResponseEntity.ok(alltxns);
	}

	@GetMapping("/user")
	public ResponseEntity<?> txnOfUser(@RequestParam String netbankingId)
	{
		List<Transactions> usertxn = txnService.getTxnOfFromUserId(netbankingId);
		return ResponseEntity.ok(usertxn);
	}
	
	@GetMapping("/gettxn")
	public ResponseEntity<?> getTxn(@RequestParam String transactionId)
	{
		Transactions txn = txnService.getTxn(transactionId);
		return ResponseEntity.ok(txn);
	}

	@GetMapping("/txnoftype")
	public ResponseEntity<?> txnOfType(@RequestParam String transactionType)
	{
		List<Transactions> txnoftype = txnService.getTxnOfType(transactionType);
		return ResponseEntity.ok(txnoftype);
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<?> txn(@RequestBody TransferRequestDto transferRequestDto)
	{
		TransferResponse transfer = txnService.transfer(transferRequestDto);
		return ResponseEntity.ok(transfer);
	}
	
	
	
	
}
