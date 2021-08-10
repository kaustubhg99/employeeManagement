package com.empApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empApp.models.Department;
import com.empApp.models.Employee;
import com.empApp.services.DepartmentService;
import com.empApp.services.EmployeeService;

@RestController
@RequestMapping("/emp/api/v1/public")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/getEmployees")
	public ResponseEntity<String> getEmployees() {
		
		return new ResponseEntity<String>("Employee : ABC", HttpStatus.OK);
		
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp){	
		
		Department dept = departmentService.getDepartmentById(emp.getDept().getDept_Id());
		
		if(dept!=null) {
			if (service.saveEmployee(emp)==true) {
				return new ResponseEntity<String>("Employee Save", HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Employee Not Saved", HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<String>("Employee Not Saved", HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
