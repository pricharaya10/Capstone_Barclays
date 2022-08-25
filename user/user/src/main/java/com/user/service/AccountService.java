package com.user.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.Account;


public interface AccountService extends JpaRepository<Account,Long> {

}
