package com.empApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empApp.models.JwtRequest;
import com.empApp.models.JwtResponse;
import com.empApp.security.helper.JwtUtil;
import com.empApp.services.CustomUserDetailsService;


@RestController
@RequestMapping("/emp/api/v1/public")
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jetRequest) throws Exception{
		
		System.out.println("token ");
		System.out.println(jetRequest);
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jetRequest.getUsername(), jetRequest.getPassword()));
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		//fine area
		UserDetails details =this.customUserDetailsService.loadUserByUsername(jetRequest.getUsername());
		String token = this.jwtUtil.generateToken(details);
		System.out.println("JWT : "+token);
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
