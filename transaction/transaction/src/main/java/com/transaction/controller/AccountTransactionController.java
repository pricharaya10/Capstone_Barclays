package com.transaction.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.transaction.service.AccountTransactionService;
import com.transaction.service.CsvExportService;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/accounttrans")
@RestController
public class AccountTransactionController {
	
private AccountTransactionService accountService;

	private CsvExportService csvExportService = new CsvExportService();
	
	public void AccountController(CsvExportService csvExportService) {
	    this.csvExportService = csvExportService;
	}
	
	@RequestMapping(path = "/getCSV")
	public void getAllEmployeesInCsv(HttpServletResponse servletResponse) throws IOException {
	    servletResponse.setContentType("text/csv");
	    servletResponse.addHeader("Content-Disposition","attachment; filename=\"payment.csv\"");
	    csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
	}
	
	@Autowired
	public void setEmployeeService(AccountTransactionService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AccountTransaction>> getAll() {
		return ResponseEntity.ok(accountService.findAll());
	}
	
	@GetMapping("/{sequenceId}")
	public ResponseEntity<AccountTransaction> findById(@PathVariable Long sequenceId) {
		return ResponseEntity.ok(accountService.findById(sequenceId).orElse(null));
	}
	
	@PutMapping("/")
	public ResponseEntity<AccountTransaction> add(@RequestBody AccountTransaction accountTransaction) {
		return ResponseEntity.ok(accountService.save(accountTransaction));
	}
	
	@PostMapping("/")
	public ResponseEntity<AccountTransaction> update(@RequestBody AccountTransaction accountTransaction) {
		return ResponseEntity.ok(accountService.save(accountTransaction));
	}

	@DeleteMapping("/{sequenceId}")
	public ResponseEntity<AccountTransaction> delete(@PathVariable Long sequenceId) {
		accountService.findById(sequenceId).ifPresent(accountService::delete);
		return ResponseEntity.ok().build();
	}

}
