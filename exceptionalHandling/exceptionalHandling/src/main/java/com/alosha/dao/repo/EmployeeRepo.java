package com.alosha.dao.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alosha.dao.entities.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	
	public Optional<List<Employee>> findByEmployeeName(String employeeName);
	
}
