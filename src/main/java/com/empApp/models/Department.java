package com.empApp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Department {

	@Id
	private Integer dept_Id;
	private String dept_Name;
	
	@OneToOne(mappedBy = "dept")
	Employee emp;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(Integer dept_Id, String dept_Name) {
		super();
		this.dept_Id = dept_Id;
		this.dept_Name = dept_Name;
	}
	public Integer getDept_Id() {
		return dept_Id;
	}
	public void setDept_Id(Integer dept_Id) {
		this.dept_Id = dept_Id;
	}
	public String getDept_Name() {
		return dept_Name;
	}
	public void setDept_Name(String dept_Name) {
		this.dept_Name = dept_Name;
	}
	@Override
	public String toString() {
		return "Department [dept_Id=" + dept_Id + ", dept_Name=" + dept_Name + "]";
	}
	
	
}
