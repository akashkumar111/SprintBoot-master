package com.reed.dao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	private long empId;
	private String empName;
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(unique = true)
	private String email;
	
}
