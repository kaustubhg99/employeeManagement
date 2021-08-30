package com.empApp.controllers;

import java.util.Date;
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

import com.empApp.models.ApiResponse;
import com.empApp.models.Department;
import com.empApp.models.ResponseStatus;
import com.empApp.services.DepartmentService;

@RestController
@RequestMapping("/emp/api/v1/dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	@GetMapping("/getDepartments")
	public ResponseEntity<ApiResponse> getDepartments(){
		List<Department> deptList = service.getDepartments();
		ApiResponse response = new ApiResponse(deptList, new ResponseStatus(new Date(), "", true));
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getDepartments/{id}")
	public ResponseEntity<ApiResponse> getDepartmentById(@PathVariable("id") Integer id){
		
		Department dept = service.getDepartmentById(id);
		ApiResponse response = new ApiResponse(dept, new ResponseStatus(new Date(), "", true));
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
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
