package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegisteredBiller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billerSequenceID;
	@Column
	private long billerCode;
	@Column
	private long consumerNumber;
	@Column
	private long accountNumber;
	@Column
	private boolean autoPay;
	@Column
	private long autoPayLimit;
	public RegisteredBiller() {
		super();
	}
	@Override
	public String toString() {
		return "RegisteredBiller [billerSequenceID=" + billerSequenceID + ", billerCode=" + billerCode
				+ ", consumerNumber=" + consumerNumber + ", accountNumber=" + accountNumber + ", autoPay=" + autoPay
				+ ", autoPayLimit=" + autoPayLimit + "]";
	}
	public long getBillerSequenceID() {
		return billerSequenceID;
	}
	public void setBillerSequenceID(long billerSequenceID) {
		this.billerSequenceID = billerSequenceID;
	}
	public long getBillerCode() {
		return billerCode;
	}
	public void setBillerCode(long billerCode) {
		this.billerCode = billerCode;
	}
	public long getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public boolean isAutoPay() {
		return autoPay;
	}
	public void setAutoPay(boolean autoPay) {
		this.autoPay = autoPay;
	}
	public long getAutoPayLimit() {
		return autoPayLimit;
	}
	public void setAutoPayLimit(long autoPayLimit) {
		this.autoPayLimit = autoPayLimit;
	}
	
	

}
