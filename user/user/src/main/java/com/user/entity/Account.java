package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sequenceId;
	@Column(unique=true)
	private Long accountNo;
	@Column
    private String name;
	@Column(unique=true)
    private String emailAddress;
	@Column
    private long currentBalance;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Long sequenceId, Long accountNo, String name, String emailAddress, long currentBalance) {
		super();
		this.sequenceId = sequenceId;
		this.accountNo = accountNo;
		this.name = name;
		this.emailAddress = emailAddress;
		this.currentBalance = currentBalance;
	}
	public Long getSequenceId() {
		return sequenceId;
	}
	public void setSequenceId(Long sequenceId) {
		this.sequenceId = sequenceId;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public long getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(long currentBalance) {
		this.currentBalance = currentBalance;
	}
	@Override
	public String toString() {
		return "Account [sequenceId=" + sequenceId + ", accountNo=" + accountNo + ", name=" + name + ", emailAddress="
				+ emailAddress + ", currentBalance=" + currentBalance + "]";
	}
    
	

	

}
