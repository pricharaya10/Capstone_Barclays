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

import com.transaction.entity.AccountTransaction;
import com.transaction.entity.Bill;
import com.transaction.service.BillService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bill")
@RestController
public class BillController {
	
private BillService billService;
	
int x=50;
	
	
	@Autowired
	public void setEmployeeService(BillService billService) {
		this.billService = billService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Bill>> getAll() {
		return ResponseEntity.ok(billService.findAll());
	}
	
	@GetMapping("/pay/{billSequenceId}")
	public String changeBillStatus(@PathVariable Long billSequenceId) {
		billService.changeBillStatus(billSequenceId);
		billService.update_account_transaction(billSequenceId,x++);
		return "SUCCESSFULL";
	}
	
	@GetMapping("/autopay")
	public String autoPay() {
		 for(Bill bill:billService.autoPay()){
			 changeBillStatus(bill.getBillSequenceId());
		 }
		 return "SUCCESSFULL";
	}
	
	@GetMapping("/pending")
	public ResponseEntity<List<Bill>> getPendingBill(){
		return ResponseEntity.ok(billService.getPendingBill("PENDING"));
	}
	
	@GetMapping("/billerCode/{billerCode}")
	public ResponseEntity<List<Bill>> getSelectedBiller(@PathVariable long billerCode){
		return ResponseEntity.ok(billService.getSelectedBiller(billerCode));
	}
	
	@GetMapping("/{billerCode}")
	public ResponseEntity<Bill> findById(@PathVariable Long billerCode) {
		return ResponseEntity.ok(billService.findById(billerCode).orElse(null));
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Bill> add(@RequestBody Bill bill) {
		return ResponseEntity.ok(billService.save(bill));
	}
	
	@PostMapping("/")
	public ResponseEntity<Bill> update(@RequestBody Bill bill) {
		return ResponseEntity.ok(billService.save(bill));
	}

	@DeleteMapping("/{billSequenceId}")
	public ResponseEntity<Bill> delete(@PathVariable Long billSequenceId) {
		billService.findById(billSequenceId).ifPresent(billService::delete);
		return ResponseEntity.ok().build();
	}

}
