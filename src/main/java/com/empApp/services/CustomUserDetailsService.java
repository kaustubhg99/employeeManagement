package com.empApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.empApp.customExceptions.UserNotExistException;
import com.empApp.models.User;
import com.empApp.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//List<SimpleGrantedAuthority> roles = null;
		 User user = repository.findByUsername(username);
		 
		if(user!=null) {
			return new CustomUserDetails(user);
		}else {
			throw new UserNotExistException("User not found",false);
		}
		

	}
}
