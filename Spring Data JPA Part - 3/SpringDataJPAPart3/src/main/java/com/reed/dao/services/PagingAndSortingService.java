package com.reed.dao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.reed.dao.entities.Employee;
import com.reed.dao.repos.EmployeeRepo;

@Service
public class PagingAndSortingService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	public List<Employee> saveEmployees(List<Employee> allEmployees)
	{
	return	(List<Employee>)employeeRepo.saveAll(allEmployees);
	}

	public List<Employee> findPagedAndSortedEmployees(int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC,"dob"));
		Page<Employee> pagedResponse = employeeRepo.findAll(pageable);
		
		System.out.println("Total number of pages :: "+pagedResponse.getTotalPages());
		
		List<Employee> allEmployees = pagedResponse.getContent();
		return allEmployees;
	}

	public List<Employee> findPagedEmployees(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Employee> pagedResponse = employeeRepo.findAll(pageable);
		
		System.out.println("Total number of pages :: "+pagedResponse.getTotalPages());
		
		List<Employee> allEmployees = pagedResponse.getContent();
		return allEmployees;
	}
	
	public List<Employee> findSortedEmployees() {
	
		Iterable<Employee> allEmployees = employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "empName"));
		
		
		return (List<Employee>) allEmployees;
	}
	
	
}
