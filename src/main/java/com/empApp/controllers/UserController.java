package com.empApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empApp.models.User;
import com.empApp.services.UserService;

@RestController
@RequestMapping("/emp/api/v1/public")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		service.addUser(user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(service.getAllUsers(), HttpStatus.OK);
	}
}
