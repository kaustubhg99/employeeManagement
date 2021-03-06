package com.empApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empApp.models.Department;
import com.empApp.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repository;

	public List<Department> getDepartments(){
		return repository.findAll();
	}
	
	public Department getDepartmentById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	
	public boolean saveDepartment(Department dept) {
		
		dept = repository.save(dept);
		
		if(dept!=null) {
			return true;
		}else {
			return false;
		}
		
	}

}
