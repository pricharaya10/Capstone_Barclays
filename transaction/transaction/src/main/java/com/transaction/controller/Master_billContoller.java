package com.transaction.controller;

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

import com.transaction.entity.Master_bill;
import com.transaction.service.Master_billService;



@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Master_bill")
@RestController
public class Master_billContoller {

private Master_billService master_billservice;
	
	@Autowired
	public void setEmployeeService(Master_billService master_billservice) {
		this.master_billservice = master_billservice;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Master_bill>> getAll() {
		return ResponseEntity.ok(master_billservice.findAll());
	}
	
	@GetMapping("/{Biller_ID}")
	public ResponseEntity<Master_bill> findById(@PathVariable Long Biller_ID) {
		return ResponseEntity.ok(master_billservice.findById(Biller_ID).orElse(null));
	}
	
	@PutMapping("/")
	public ResponseEntity<Master_bill> add(@RequestBody Master_bill master_bill) {
		return ResponseEntity.ok(master_billservice.save(master_bill));
	}
	
	@PostMapping("/")
	public ResponseEntity<Master_bill> update(@RequestBody Master_bill master_bill) {
		return ResponseEntity.ok(master_billservice.save(master_bill));
	}

	@DeleteMapping("/{Biller_ID}")
	public ResponseEntity<Master_bill> delete(@PathVariable Long Biller_ID) {
		master_billservice.findById(Biller_ID).ifPresent(master_billservice::delete);
		return ResponseEntity.ok().build();
	}

}
