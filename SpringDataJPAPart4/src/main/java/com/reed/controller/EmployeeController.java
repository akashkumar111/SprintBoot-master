package com.reed.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reed.dao.entities.Employee;
import com.reed.service.EmployeeService;

import lombok.extern.java.Log;

@RestController
@Log
public class EmployeeController {
 
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employees")
	public ResponseEntity<Object> save(@RequestBody List<Employee> allEmp)
	{
		log.info("About to save all Employees");
		List<Employee> savedAllEmp = employeeService.save(allEmp);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedAllEmp);
		
	}
	
	@GetMapping("/employees/{email}")
	public ResponseEntity<Object> findEmployeeByEmail(@PathVariable String email)
	{
		log.info("About to find employee by email "+email);
		Employee employee = employeeService.findByEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@GetMapping("/employees/api/{startName}")
	public ResponseEntity<Object> findEmployeeByStartingEmpName(@PathVariable String startName)
	{
		log.info("About to find employee by starting name "+startName);
		List<Employee> findByEmpNameStartsWith = employeeService.findByEmpNameStartsWith(startName);
		return ResponseEntity.status(HttpStatus.OK).body(findByEmpNameStartsWith);
	}
	
	@GetMapping("/employees/api/{empName}/{email}")
	public ResponseEntity<Object> findEmployeeByStartingEmpName(@PathVariable String empName,@PathVariable String email)
	{
		
		log.info("About to find employee by empName or email");
		
		List<Employee>  findByEmpNameStartsWithorDob = employeeService.findByEmpNameOrEmailStartBy(empName,email);
		return ResponseEntity.status(HttpStatus.OK).body(findByEmpNameStartsWithorDob);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<Object> findAllEmployeeSortedNative()
	{
		log.info("About to find all Employees sorted by empName");
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.findAllEmployeeSortedNative());
		
	}
	
	@DeleteMapping("/employees/{empName}")
	public ResponseEntity<Object> deleteByEmpName(@PathVariable String empName)
	{
		log.info("About to delete employee by empName "+empName);
		employeeService.deleteByEmpName(empName);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@PutMapping("/employees/{newEmpName}/{empName}")
	public ResponseEntity<Object> deleteByEmpName(@PathVariable String newEmpName,@PathVariable String empName)
	{
		log.info("About to update employee by empName "+empName);
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateByEmpName(newEmpName, empName));
	}
	
	@GetMapping("/employees/paged/{empName}")
	public ResponseEntity<Object> findByEmpNameStartsWithAndPaged(@PathVariable String empName)
	{
		
		log.info("About to find employee by empName starts with "+empName+" and paged...");
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.findByEmpNameStartsWithAndPaged(empName));
	}
	
}
