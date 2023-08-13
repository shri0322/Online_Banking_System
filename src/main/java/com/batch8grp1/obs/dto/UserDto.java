package com.batch8grp1.obs.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	

	private String userId;
	private String title;
	private String firstName;
	private String lastname;
	private String fatherName;
	private String mobileNo;
	private String emailId;
	private String aadharNo;
	private String dOB;
	private String address;
	private String occupationType;
	private String sourceofIncome;
	private String grossAnnualIncome;
	private String accountId;

	public UserDto() {}
	
	public UserDto(String firstName, String lastname, String fatherName, String mobileNo, String emailId,
			String aadharNo, String dOB, String address, String occupationType, String sourceofIncome,
			String grossAnnualIncome, String accountId) {
		super();
		//this.userId = userId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.fatherName = fatherName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.aadharNo = aadharNo;
		this.dOB = dOB;
		this.address = address;
		this.occupationType = occupationType;
		this.sourceofIncome = sourceofIncome;
		this.grossAnnualIncome = grossAnnualIncome;
		this.accountId = accountId;
	}

	public String getUserId() {
		return userId;
	}
	public String getAccountId() {
		return accountId;
	}

}
