package com.transaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Master_bill {
	
	@Id
	@Column(unique=true)
	private Long Biller_ID;
	@Column
    private String Name;
    
    
    
	public Master_bill() {
		super();
	}


	public Master_bill(Long billerId, String name) {
		super();
		this.Biller_ID = billerId;
		this.Name = name;
		
	}


	public Long getBiller_ID() {
		return Biller_ID;
	}


	public void setBiller_ID(Long billerId) {
		this.Biller_ID = billerId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		this.Name = name;
	}


	@Override
	public String toString() {
		return "Master_bill [Biller_ID=" + Biller_ID + ", Name=" + Name + "]";
	}


	

}
