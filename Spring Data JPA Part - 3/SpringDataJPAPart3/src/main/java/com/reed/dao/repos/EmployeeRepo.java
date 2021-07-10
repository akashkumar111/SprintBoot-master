package com.reed.dao.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.reed.dao.entities.Employee;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Long>{

}
