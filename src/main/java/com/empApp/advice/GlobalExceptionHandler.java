package com.empApp.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.empApp.controllers.EmpNotFoundException;
import com.empApp.models.ApiResponse;
import com.empApp.models.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmpNotFoundException.class)
	public ResponseEntity<ApiResponse> empNotFoundExceptionHandler(EmpNotFoundException empNotFoundException){
		
		ApiResponse response = new ApiResponse("", new ResponseStatus(new Date(), "Employee does not exist in database", false));
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ApiResponse> userNotFoundExceptionHandler(UsernameNotFoundException usernameNotFoundException){
		ApiResponse response = new ApiResponse("", new ResponseStatus(new Date(), "You dont have access to resources. please contact to Admin", false));
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ApiResponse> badCredentialsExceptionHandler(BadCredentialsException badCredentialsException){
		ApiResponse response = new ApiResponse("", new ResponseStatus(new Date(), "Please check your credentials", false));
		return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
	}
}
