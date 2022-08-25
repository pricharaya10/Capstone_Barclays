package com.user.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.user.entity.User;
import com.user.service.UserService;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
@RestController
public class UserController {
	
private UserService userServices;
	
	@Autowired
	public void setEmployeeService(UserService userServices) {
		this.userServices = userServices;
	}
	
	@GetMapping("/{LoginId}/{Password}")
	public String checkLogin(@PathVariable Long LoginId, @PathVariable String Password){
		var result = userServices.checkLogin(LoginId, Password);
		if(result.isEmpty()) {
			return "Login failed";
		}
		else {
			return "Login successful";
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(userServices.findAll());
	}
	
	@GetMapping("/{LoginId}")
	public ResponseEntity<User> findById(@PathVariable Long LoginId) {
		return ResponseEntity.ok(userServices.findById(LoginId).orElse(null));
	}
	
	@PutMapping("/")
	public ResponseEntity<User> add(@RequestBody User user) {
		return ResponseEntity.ok(userServices.save(user));
	}
	
	@PostMapping("/")
	public ResponseEntity<User> update(@RequestBody User user) {
		return ResponseEntity.ok(userServices.save(user));
	}

	@DeleteMapping("/{LoginId}")
	public ResponseEntity<User> delete(@PathVariable Long LoginId) {
		userServices.findById(LoginId).ifPresent(userServices::delete);
		return ResponseEntity.ok().build();
	}

}
