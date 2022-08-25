package com.transaction.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.entity.AccountTransaction;

public interface AccountTransactionService extends JpaRepository<AccountTransaction,Long>{
	
	

}
