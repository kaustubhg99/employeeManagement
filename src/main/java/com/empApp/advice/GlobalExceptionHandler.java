package com.empApp.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.empApp.controllers.EmpNotFoundException;
import com.empApp.models.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmpNotFoundException.class)
	public ResponseEntity<ResponseStatus> empNotFoundExceptionHandler(EmpNotFoundException empNotFoundException){
		return new ResponseEntity<ResponseStatus>(new ResponseStatus(new Date(), "Employee Id does not exists in Database", false), HttpStatus.NOT_FOUND);
	}
}
