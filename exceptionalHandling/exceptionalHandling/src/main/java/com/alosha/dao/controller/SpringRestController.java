package com.alosha.dao.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alosha.dao.entities.Employee;
import com.alosha.dao.service.RestService;

@RestController
public class SpringRestController {
	
	@Autowired
	RestService service;

	@PostMapping(value = "/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		Employee employeePersisted = service.saveEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{empid}").build(employeePersisted.getEmpId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(employeePersisted);
		
	}
	
	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> retrieveEmployee(@PathVariable long id)
	{
		Employee employeePersisted = service.retrieveEmployee(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(employeePersisted);
		
	}
	
	@GetMapping(value = "/employees/allname/{name}")
	public ResponseEntity<List<Employee>> retrieveEmployee(@PathVariable String name)
	{
		
		Employee employee = null;
		employee.getAge();
		
		List<Employee> employeePersisted = service.retrieveAllEmployeeByEmployeeName(name);
		
		return ResponseEntity.status(HttpStatus.OK).body(employeePersisted);
		
	}
	
}
