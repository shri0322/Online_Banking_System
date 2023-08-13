package com.batch8grp1.obs.entity;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name="UserDetails")
public class User {

	@Id
	@Column(name="UserId",nullable=false)
	private String userId;
	
	@Column(name="Title",nullable=false)
	private String title;
	
	@Column(name="Firstname",nullable=false)
	private String firstName;
	
	@Column(name="Lastname",nullable=false)
	private String lastname;

	@Column(name="Fathername",nullable=false)
	private String fatherName;
	
	@Column(name="MobileNo",nullable=false)
	private String mobileNo;
	
	@Column(name="EmailId",nullable=false)
	private String emailId;
	
	@Column(name="AadharNo",nullable=false)
	private String aadharNo;

	@Column(name="DoB",nullable=false)
	private String dOB;
	
	@Column(name="Address",nullable=false)
	private String address;
	
	@Column(name="OccupationType",nullable=false)
	private String occupationType;
	
	@Column(name="SourceofIncome",nullable=false)
	private String sourceofIncome;
	
	@Column(name="GrossAnnualIncome",nullable=false)
	private String grossAnnualIncome;
	
	@Column(name="AccountId",nullable=false)
	private String accountId;
	
	public User(String title, String firstName, String lastname, String fatherName, String mobileNo, String emailId,
			String aadharNo, String dOB, String address, String occupationType, String sourceofIncome,
			String grossAnnualIncome) {
		super();
		this.userId = setUserId();
		this.title=title;
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

}
