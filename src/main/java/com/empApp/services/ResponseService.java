package com.empApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

public class ResponseService<T> {

	private T body;
	private String message;
	private boolean success ;
	
	public ResponseService(T body, String message, boolean success) {
		super();
		 if (this.body instanceof List) {
            
         }
		 else {
			 body = body;
		 }
		
		this.message = message;
		this.success = success;
	}
	
	
	
}
