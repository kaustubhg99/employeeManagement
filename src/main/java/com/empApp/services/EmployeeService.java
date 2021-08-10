package com.empApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empApp.models.Employee;
import com.empApp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	public boolean saveEmployee(Employee emp) {
		repository.save(emp);
		return true;
	}
}
