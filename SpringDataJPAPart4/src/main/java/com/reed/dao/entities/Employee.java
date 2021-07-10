package com.reed.dao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Employee.findByEmail",query = "select e from Employee e where e.email=?1")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	private String empName;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date dob;
	private String role;
	@Column(unique = true)
	private String email;
	
}
