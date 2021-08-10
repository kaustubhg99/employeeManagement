package com.empApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empApp.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
