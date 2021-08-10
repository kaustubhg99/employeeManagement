package com.empApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empApp.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
