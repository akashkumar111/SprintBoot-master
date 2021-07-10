package com.alosha.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private long empId;
	private String employeeName;
	private int age;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Employee(long empId, String employeeName, int age) {
		super();
		this.empId = empId;
		this.employeeName = employeeName;
		this.age = age;
	}



	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
