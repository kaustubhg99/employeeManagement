package com.empApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empApp.customExceptions.EmpNotFoundException;
import com.empApp.models.Employee;
import com.empApp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	public boolean saveEmployee(Employee emp) {
		Employee empAdded = repository.save(emp);
		
		if(empAdded!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	
	public Employee getEmployeeById(Integer id) {
		
		return repository.findById(id).orElseThrow(
				() -> new EmpNotFoundException("Employee Id not exists in Database", false));
	}

	public boolean updateEmployee(Employee emp) {
		
		repository.findById(emp.getEmp_Id()).orElseThrow(
				() -> new EmpNotFoundException("Employee not exist with id "+emp.getEmp_Id(), false));
		/*
		 * existingEmp.setEmp_FirstName(emp.getEmp_FirstName());
		 * existingEmp.setEmp_LastName(emp.getEmp_LastName());
		 * existingEmp.setEmp_DOB(emp.getEmp_DOB());
		 * existingEmp.setEmp_Salary(emp.getEmp_Salary());
		 * existingEmp.getDept().setDept_Id(emp.getDept().getDept_Id());
		 * existingEmp.getDept().setDept_Name(emp.getDept().getDept_Name());
		 */
		
		repository.save(emp);
		
		return true;
		
	}
}
