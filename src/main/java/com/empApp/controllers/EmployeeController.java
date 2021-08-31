package com.empApp.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empApp.models.ApiResponse;
import com.empApp.models.Department;
import com.empApp.models.Employee;
import com.empApp.models.ResponseStatus;
import com.empApp.services.DepartmentService;
import com.empApp.services.EmployeeService;
import com.empApp.services.ResponseService;

@RestController
@RequestMapping("/emp/api/v1/emp")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/getEmployees")
	public ResponseEntity<ApiResponse> getEmployees() {
		List<Employee> empl = service.getEmployees();
		System.out.println(empl);
		ApiResponse response = new ApiResponse(empl, new ResponseStatus(new Date(), "", true));
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	
	}
	
	@GetMapping("/getEmployees/{id}")
	public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable("id") Integer id) {
		Employee empl = service.getEmployeeById(id);
	
		System.out.println(empl);
		ApiResponse response = new ApiResponse(empl, new ResponseStatus(new Date(), "", true));
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);		
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<ApiResponse> addEmployee(@RequestBody Employee emp){	
		
		Department dept = departmentService.getDepartmentById(emp.getDept().getDept_Id());

		if(dept!=null) {
			if (service.saveEmployee(emp)==true) {
				ApiResponse response = new ApiResponse(emp, new ResponseStatus(new Date(), "New Employee Added successfully,", true));
				return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
			}else {
				ApiResponse response = new ApiResponse(null, new ResponseStatus(new Date(), "failed to add New Employee.", false));
				return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
			}
		}else {
			ApiResponse response = new ApiResponse(null, new ResponseStatus(new Date(), "Wrong department selected", false));
			return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<ApiResponse> updateEmployee(@RequestBody Employee emp) {
		
		Department dept = departmentService.getDepartmentById(emp.getDept().getDept_Id());
		ApiResponse response = null;
		if(dept!=null) {
			service.updateEmployee(emp);
			response= new ApiResponse(emp, new ResponseStatus(new Date(), "Employee Successfully Updated", true));
			return  new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		}else {
			response = new ApiResponse(null, new ResponseStatus(new Date(), "Wrong department selected", false));
			return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
		}
	
	}
}
