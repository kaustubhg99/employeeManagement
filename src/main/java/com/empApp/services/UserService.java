package com.empApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.empApp.models.User;
import com.empApp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public boolean addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		repository.save(user);
		return true;
	}
	
	public List<User> getAllUsers() {
		return repository.findAll();
	}
}
