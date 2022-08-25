package com.transaction.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.entity.AccountTransaction;

@Repository
public interface AccountRepository extends JpaRepository<AccountTransaction,Integer> {
	
}