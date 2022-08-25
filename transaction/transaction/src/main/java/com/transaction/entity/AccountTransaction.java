package com.transaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sequenceId;
	@Column
	private Long transactionRef;
	@Column
	private String date;
	@Column
	private String time;
	@Column
	private Long amount;
	@Column
	private String type;
	@Column
	private String description;
	@Column
	private Long billRefNumber;
	
	public AccountTransaction() {
		super();
	}
	
	
	
	public AccountTransaction(Long transactionRef, String date, String time, Long amount, String type,
			String description, Long billRefNumber) {
		super();
		this.transactionRef = transactionRef;
		this.date = date;
		this.time = time;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.billRefNumber = billRefNumber;
	}



	public Long getSequenceId() {

			return sequenceId;
		
	}



	public void setSequenceId(Long sequenceId) {
		this.sequenceId = sequenceId;
	}



	public Long getTransactionRef() {
		return transactionRef;
	}



	public void setTransactionRef(Long transactionRef) {
		this.transactionRef = transactionRef;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public Long getAmount() {
		return amount;
	}



	public void setAmount(Long amount) {
		this.amount = amount;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Long getBillRefNumber() {
		return billRefNumber;
	}



	public void setBillRefNumber(Long billRefNumber) {
		this.billRefNumber = billRefNumber;
	}



	public AccountTransaction(Long sequenceId, Long transactionRef, String date, String time, Long amount, String type,
			String description, Long billRefNumber) {
		super();
		this.sequenceId = sequenceId;
		this.transactionRef = transactionRef;
		this.date = date;
		this.time = time;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.billRefNumber = billRefNumber;
	}



	@Override
	public String toString() {
		return "AccountTransaction [sequenceId=" + sequenceId + ", transactionRef=" + transactionRef + ", date=" + date
				+ ", time=" + time + ", amount=" + amount + ", type=" + type + ", description=" + description
				+ ", billRefNumber=" + billRefNumber + "]";
	}
	
	

}
