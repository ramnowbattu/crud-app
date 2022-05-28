package com.ram.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.demo.service.UserService;
import com.ram.demo.user.User;

@RestController
@RequestMapping("/app")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User savedUser = service.saveUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsersList(){
		List<User> userList = service.getUsersList();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable ("userId") Long userId){
		User userById = service.getUserById(userId);
		return new ResponseEntity<User>(userById, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable ("userId") Long userId){
		String deletedMessage = service.deleteUserById(userId);
		return new ResponseEntity<String>(deletedMessage, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable("userId") Long userId){
		User updatedUser = service.updateUserById(user, userId);
		return new ResponseEntity<User>(updatedUser, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
