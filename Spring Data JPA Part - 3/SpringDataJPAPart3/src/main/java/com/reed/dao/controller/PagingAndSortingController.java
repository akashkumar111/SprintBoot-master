package com.reed.dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reed.dao.entities.Employee;
import com.reed.dao.services.PagingAndSortingService;

@RestController
public class PagingAndSortingController {

	@Autowired
	PagingAndSortingService pagingAndSortingService;
	
	
	
	@PostMapping("/employees")
	public ResponseEntity<Object> saveAllEmployees(@RequestBody List<Employee> allEmployees)
	{
		List<Employee> savedEmployees = pagingAndSortingService.saveEmployees(allEmployees);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployees);
	}
	
	
	@GetMapping("/employees/{page}/{size}")
	public ResponseEntity<Object> findAllEmployees(@PathVariable int page,@PathVariable int size)
	{
		List<Employee> savedEmployees = pagingAndSortingService.findPagedEmployees(page,size);
		return ResponseEntity.status(HttpStatus.OK).body(savedEmployees);
	}
	
	@GetMapping("/employees/sort/{page}/{size}")
	public ResponseEntity<Object> findAllEmployeesAndSort(@PathVariable int page,@PathVariable int size)
	{
		List<Employee> savedEmployees = pagingAndSortingService.findPagedAndSortedEmployees(page,size);
		return ResponseEntity.status(HttpStatus.OK).body(savedEmployees);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<Object> findAllEmployeesSorted()
	{
		List<Employee> savedEmployees = pagingAndSortingService.findSortedEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(savedEmployees);
	}
	
}
