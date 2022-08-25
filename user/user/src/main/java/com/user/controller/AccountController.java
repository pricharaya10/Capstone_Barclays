package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Account;
import com.user.entity.User;
import com.user.service.AccountService;
import com.user.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/account")
@RestController
public class AccountController {
	
private AccountService accountService;
	
	@Autowired
	public void setEmployeeService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Account>> getAll() {
		return ResponseEntity.ok(accountService.findAll());
	}
	
	@GetMapping("/{sequenceId}")
	public ResponseEntity<Account> findById(@PathVariable Long sequenceId) {
		return ResponseEntity.ok(accountService.findById(sequenceId).orElse(null));
	}
	
	@PutMapping("/")
	public ResponseEntity<Account> add(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.save(account));
	}
	
	@PostMapping("/")
	public ResponseEntity<Account> update(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.save(account));
	}

	@DeleteMapping("/{sequenceId}")
	public ResponseEntity<Account> delete(@PathVariable Long sequenceId) {
		accountService.findById(sequenceId).ifPresent(accountService::delete);
		return ResponseEntity.ok().build();
	}
}

