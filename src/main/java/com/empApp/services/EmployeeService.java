package com.empApp.services;

import java.util.List;

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
	
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	
	public Employee getEmployeeById(Integer id) {
		return repository.findById(id).orElse(null);
	}
}
