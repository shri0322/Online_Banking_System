package com.batch8grp1.obs.dto;

public class BeneficiaryDto {
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private String netbankingIdOfPayee;
	private String accountId;
	private String name;
	
	
	
	public BeneficiaryDto(String netbankingIdOfPayee, String beneficiaryAccountId, String beneficiaryName) {
		super();
		this.netbankingIdOfPayee = netbankingIdOfPayee;
		this.accountId = beneficiaryAccountId;
		this.name = beneficiaryName;
	}
	
	public String getNetbankingIdOfPayee() {
		return netbankingIdOfPayee;
	}
	public void setNetbankingIdOfPayee(String netbankingIdOfPayee) {
		this.netbankingIdOfPayee = netbankingIdOfPayee;
	}
	

}
