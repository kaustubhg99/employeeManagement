package com.empApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empApp.models.Department;
import com.empApp.services.DepartmentService;

@RestController
@RequestMapping("/emp/api/v1/public")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;

	@PostMapping("/addDepartment")
	public ResponseEntity<String> addNewDepartment(@RequestBody Department dept) {
		 
		if (service.saveDepartment(dept)==true) {
			return new ResponseEntity<>("Department Added", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Department Added", HttpStatus.BAD_REQUEST);
		}
		 
	}
}
