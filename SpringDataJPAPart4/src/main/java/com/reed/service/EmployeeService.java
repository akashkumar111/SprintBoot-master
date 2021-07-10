package com.reed.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.reed.dao.entities.Employee;
import com.reed.dao.repos.EmployeeRepo;

import lombok.extern.java.Log;

@Service
@Log
public class EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	
	public List<Employee> save(List<Employee> allEmp)
	{
		return (List<Employee>) employeeRepo.saveAll(allEmp);
	}

	public Employee findByEmail(String email) {
		return	employeeRepo.findByEmail(email);
		}
	
	
	public List<Employee> findByEmpNameStartsWith(String startName) {
		return employeeRepo.findByEmpNameStartsWith(startName);
	}
		
	public List<Employee> findByEmpNameOrEmailStartBy(String empName,String email) {
			return employeeRepo.findByEmpNameOrEmailStartBy(empName, email);
	}
	
	public List<Employee> findAllEmployeeSortedNative() {
		return	employeeRepo.findAllEmployeeSortedNative();
		}
	
	//@Transactional
		public void deleteByEmpName(String empName) {
				employeeRepo.deleteByEmpName(empName);		
			}
		
		public int updateByEmpName(String newempname,String empname) {	
			return	employeeRepo.updateByEmpName(newempname,empname);
			}
		
		
		public List<Employee> findByEmpNameStartsWithAndPaged(String empName) {
			
			Pageable pageable = (Pageable) PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "empName"));
		
		 Page<Employee> pagedEmp = employeeRepo.findByEmpNameStartsWith(empName,pageable);
		 log.info("Total pages :: "+pagedEmp.getTotalPages());
		 return pagedEmp.getContent();
	}
	
}
