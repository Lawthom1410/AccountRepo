package com.qa.persistence.domain;

import javax.persistence.*;
import javax.xml.registry.infomodel.User;

@Entity
public class Account {
	@Id @GeneratedValue
	private int accountId;
	private int accountNum;
	private String firstName;
	private String lastName;
	
	public Account(int accountId, int accountNum, String firstName, String lastName) {
		super();
		this.accountId = accountId;
		this.accountNum = accountNum;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Account() {
		
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountid) {
		this.accountId = accountid;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	//This class needs to have:
	//An id
	//An Account Number
	//A First Name
	//A last Name
	
}
