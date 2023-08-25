package com.batch8grp1.obs.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.entity.Transactions;
import com.batch8grp1.obs.exceptions.CustomException;
import com.batch8grp1.obs.repository.AccountDetailsRepository;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.TransactionsRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired private UserDetailsRepository userDetailsRepository;
	@Autowired private NetbankingRepository netbankingRepository;
	@Autowired private AccountDetailsRepository accountDetailsRepository;
	@Autowired private TransactionsRepository txnRepository;

	public List<AccountDetails> getAllAcc()
	{
		List<AccountDetails> allacc = accountDetailsRepository.findAll();
		if(allacc == null)
		{
			throw new CustomException("No accounts to Display!");
		}
		return allacc;
	}

	public List<AccountDetails> getAllAccforApproval()
	{
		List<AccountDetails> allacc = accountDetailsRepository.findAll();
		if(allacc == null)
		{
			throw new CustomException("No accounts to Display!");
		}
		List<AccountDetails> accforapproval = null;
		
		for(AccountDetails t : allacc)
		{
			if(t.getIsApproved() == null)
			{
				accforapproval.add(t);
			}
		}
		return accforapproval;
	}
	
	
	public List<Transactions> getAllTxnFromToDate(LocalDate startdate, LocalDate enddate)
	{
		List<Transactions> alltxns = txnRepository.findAll();
		if(alltxns == null)
		{
			throw new CustomException("No transactions in the selected time period");
		}
		List<Transactions> txnfromdate = null;
		//ListIterator<Transactions> itr = txnfromuser.listIterator();
		for(Transactions t : alltxns)
		{
			LocalDate txnDate = toDate(t.getCompletedAt());
			if(txnDate.isBefore(enddate) && txnDate.isAfter(startdate))
			{
				txnfromdate.add(t);
			}
		}
		return txnfromdate;

	}
	
	public List<Transactions> getTxnFromToDate(String netbankingId,LocalDate startdate, LocalDate enddate)
	{

		String accountId = netbankingRepository.findByNetbankingId(netbankingId).getAccountId().toString();
		//AccountDetails fromaccount=accountDetailsRepository.findByAccountId(accountId);
		
		List<Transactions> txnfromuser = txnRepository.findByFromUserId(accountId);
		List<Transactions> txntouser = txnRepository.findByToUserId(accountId);

		if(txnfromuser == null || txntouser == null)
		{
			throw new CustomException("No Transactions to Display!");
		}
		List<Transactions> txnfromdate = null;
		//ListIterator<Transactions> itr = txnfromuser.listIterator();
		for(Transactions t : txnfromuser)
		{
			LocalDate txnDate = toDate(t.getCompletedAt());
			if(txnDate.isBefore(enddate) && txnDate.isAfter(startdate))
			{
				txnfromdate.add(t);
			}
		}
		for(Transactions t : txntouser)
		{
			LocalDate txnDate = toDate(t.getCompletedAt());
			if(txnDate.isBefore(enddate) && txnDate.isAfter(startdate))
			{
				txnfromdate.add(t);
			}
		}
		
		return txnfromdate;

	}
	
	public String approved(String netbankingId,String isApproved)
	{
		String accountId = netbankingRepository.findByNetbankingId(netbankingId).getAccountId().toString();
		AccountDetails account=accountDetailsRepository.findByAccountId(accountId);
		account.setIsApproved(isApproved);
		if(isApproved.equals("Accepted"))
		{
			return "Account Register Request Accepted";
		}else return "Account Register Request Rejected";
	}
	
	public LocalDate toDate(String date)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}

	
}
