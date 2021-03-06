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
import com.empApp.models.Employee;
import com.empApp.services.DepartmentService;
import com.empApp.services.EmployeeService;

@RestController
@RequestMapping("/emp/api/v1/emp")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees() {
		
		return new ResponseEntity<List<Employee>>(service.getEmployees(), HttpStatus.OK);
	
	}
	
	@GetMapping("/getEmployees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp){	
		
		Department dept = departmentService.getDepartmentById(emp.getDept().getDept_Id());
		
		if(dept!=null) {
			if (service.saveEmployee(emp)==true) {
				return new ResponseEntity<String>("Employee Save", HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Employee not Saved", HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<String>("Employee Not Saved", HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
