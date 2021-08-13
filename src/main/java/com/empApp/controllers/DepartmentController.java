package com.empApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empApp.models.Department;
import com.empApp.services.DepartmentService;

@RestController
@RequestMapping("/emp/api/v1/dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	@GetMapping("/getDepartments")
	public ResponseEntity<List<Department>> getDepartments(){
		return new ResponseEntity<List<Department>>(service.getDepartments(),HttpStatus.OK);
	}
	
	@GetMapping("/getDepartments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id){
		return new ResponseEntity<Department>(service.getDepartmentById(id), HttpStatus.OK);
	}

	@PostMapping("/addDepartment")
	public ResponseEntity<String> addNewDepartment(@RequestBody Department dept) {
		 
		if (service.saveDepartment(dept)==true) {
			return new ResponseEntity<>("Department Added", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Department Added", HttpStatus.BAD_REQUEST);
		}
		 
	}
}
