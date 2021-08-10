package com.empApp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	private Integer emp_Id;
	private String emp_FirstName;
	private String emp_LastName;
	private String emp_DOB;
	private Long emp_Salary;
	
	@OneToOne
	Department dept;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer emp_Id, String emp_FirstName, String emp_LastName, String emp_DOB, Long emp_Salary,
			Department dept) {
		super();
		this.emp_Id = emp_Id;
		this.emp_FirstName = emp_FirstName;
		this.emp_LastName = emp_LastName;
		this.emp_DOB = emp_DOB;
		this.emp_Salary = emp_Salary;
		this.dept = dept;
	}

	public Integer getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(Integer emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_FirstName() {
		return emp_FirstName;
	}
	public void setEmp_FirstName(String emp_FirstName) {
		this.emp_FirstName = emp_FirstName;
	}
	public String getEmp_LastName() {
		return emp_LastName;
	}
	public void setEmp_LastName(String emp_LastName) {
		this.emp_LastName = emp_LastName;
	}
	public String getEmp_DOB() {
		return emp_DOB;
	}
	public void setEmp_DOB(String emp_DOB) {
		this.emp_DOB = emp_DOB;
	}
	public Long getEmp_Salary() {
		return emp_Salary;
	}
	public void setEmp_Salary(Long emp_Salary) {
		this.emp_Salary = emp_Salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [emp_Id=" + emp_Id + ", emp_FirstName=" + emp_FirstName + ", emp_LastName=" + emp_LastName
				+ ", emp_DOB=" + emp_DOB + ", emp_Salary=" + emp_Salary + ", dept=" + dept + "]";
	}
	
	
	
	
}
