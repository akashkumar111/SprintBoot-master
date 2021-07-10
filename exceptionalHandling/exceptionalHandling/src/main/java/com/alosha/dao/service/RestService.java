package com.alosha.dao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alosha.dao.entities.Employee;
import com.alosha.dao.repo.EmployeeRepo;
import com.alosha.exception.ResourceNotFoundException;

@Service
public class RestService {

	@Autowired
	EmployeeRepo employeeRepo;
	//same method will be used for create and update
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	//method to fetch employee from DB
	public Employee retrieveEmployee(long id)
	{
		Optional<Employee> optional = employeeRepo.findById(id);
		return optional.get();
	
	}
	
	public List<Employee> retrieveAllEmployeeByEmployeeName(String employeeName)
	{
		
		Optional<List<Employee>> employeeListOpt= employeeRepo.findByEmployeeName(employeeName);
		
		List<Employee> allEmp = employeeListOpt.get();
		
		if(allEmp.size()<=0)
		{
			throw new ResourceNotFoundException("data is not present "+employeeName);
		}
		
		return allEmp;
	}
	
	
}
