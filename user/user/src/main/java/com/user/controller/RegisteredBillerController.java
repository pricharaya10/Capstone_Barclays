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
import com.user.entity.RegisteredBiller;
import com.user.service.AccountService;
import com.user.service.RegisteredBillerService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/registeredbiller")
@RestController
public class RegisteredBillerController {
	
	private RegisteredBillerService registeredBillerService;
	
	@Autowired
	public void setEmployeeService(RegisteredBillerService registeredBillerService) {
		this.registeredBillerService = registeredBillerService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<RegisteredBiller>> getAll() {
		return ResponseEntity.ok(registeredBillerService.findAll());
	}
	
	@GetMapping("/{billerSequenceID}")
	public ResponseEntity<RegisteredBiller> findById(@PathVariable Long billerSequenceID) {
		return ResponseEntity.ok(registeredBillerService.findById(billerSequenceID).orElse(null));
	}
	
	@PutMapping("/")
	public ResponseEntity<RegisteredBiller> add(@RequestBody RegisteredBiller registeredBiller) {
		return ResponseEntity.ok(registeredBillerService.save(registeredBiller));
	}
	
	@PostMapping("/")
	public ResponseEntity<RegisteredBiller> update(@RequestBody RegisteredBiller registeredBiller) {
		return ResponseEntity.ok(registeredBillerService.save(registeredBiller));
	}

	@DeleteMapping("/{billerSequenceID}")
	public ResponseEntity<RegisteredBiller> delete(@PathVariable Long billerSequenceID) {
		registeredBillerService.findById(billerSequenceID).ifPresent(registeredBillerService::delete);
		return ResponseEntity.ok().build();
	}

}
