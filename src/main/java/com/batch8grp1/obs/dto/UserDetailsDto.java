package com.batch8grp1.obs.dto;

import java.util.Random;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
	

	private String userId;
	private String title;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String mobileNo;
	private String emailId;
	private String aadharNo;
	private String dOB;
	private String address;
	private String occupationType;
	private String sourceOfIncome;
	private String grossAnnualIncome;
	private String accountId;

	public UserDetailsDto() {}
	
	public UserDetailsDto(String userId, String title, String firstName, String lastName, String fatherName, String mobileNo, String emailId,
			String aadharNo, String dOB, String address, String occupationType, String sourceOfIncome,
			String grossAnnualIncome,String accoundId) {
		super();
		this.userId = setUserId();
		this.title=title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.aadharNo = aadharNo;
		this.dOB = dOB;
		this.address = address;
		this.occupationType = occupationType;
		this.sourceOfIncome = sourceOfIncome;
		this.grossAnnualIncome = grossAnnualIncome;
		this.accountId = setAccountId();
	}
	
	public String setUserId() {
		Random rand = new Random();
        int userid = rand.nextInt(100000);
		this.userId = Integer.toString(userid);
		return this.userId;
	}


	public String setAccountId() {
		Random rand = new Random();
        int accountid = rand.nextInt(100000);
		this.accountId = Integer.toString(accountid);
		return this.accountId;
	}

	public String getUserId() {
		return userId;
	}
	public String getAccountId() {
		return accountId;
	}
	
	public String getTitle() {
		return title;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public String getdOB() {
		return dOB;
	}

	public String getAddress() {
		return address;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public String getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

}
