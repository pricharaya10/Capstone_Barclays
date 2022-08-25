package com.transaction.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long billSequenceId;
	private Long billerCode;
	private Long consumerNumber;
	private Long amount;
	private String dueDate;
	private String status;
	public Bill() {
		super();
	}
	public Bill(Long billSequenceId, Long billerCode, Long consumerNumber, Long amount, String dueDate, String status) {
		super();
		this.billSequenceId = billSequenceId;
		this.billerCode = billerCode;
		this.consumerNumber = consumerNumber;
		this.amount = amount;
		this.dueDate = dueDate;
		this.status = status;
	}
	public Long getBillSequenceId() {
		return billSequenceId;
	}
	public void setBillSequenceId(Long billSequenceId) {
		this.billSequenceId = billSequenceId;
	}
	public Long getBillerCode() {
		return billerCode;
	}
	public void setBillerCode(Long billerCode) {
		this.billerCode = billerCode;
	}
	public Long getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bill [billSequenceId=" + billSequenceId + ", billerCode=" + billerCode + ", consumerNumber="
				+ consumerNumber + ", amount=" + amount + ", dueDate=" + dueDate + ", status=" + status + "]";
	}
	
	

}
