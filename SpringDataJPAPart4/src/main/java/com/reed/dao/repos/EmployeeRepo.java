package com.reed.dao.repos;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.reed.dao.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	public Employee findByEmail(String email);
	
	@Query(value = "select E from Employee E where E.empName like ?1%")
	public List<Employee> findByEmpNameStartsWith(String empNameSubString);
	
	@Query(value = "select E from Employee E where E.empName like :empname% or E.email like :email%")
	public List<Employee> findByEmpNameOrEmailStartBy(@Param("empname") String empName,String email);
	
	@Query(value = "select * from employee order by emp_name desc",nativeQuery = true)
	public List<Employee> findAllEmployeeSortedNative();
	
	@Query(value = "delete from Employee E where E.empName = :empname")
	@Modifying
	@Transactional
	public void deleteByEmpName(String empname);
	
	@Query(value = "update Employee E set E.empName = :newempname where E.empName = :empname")
	@Modifying
	@Transactional
	public int updateByEmpName(String newempname,String empname);
	
	@Query(value = "select E from Employee E where E.empName like :empname%")
	public Page<Employee> findByEmpNameStartsWith(String empname,Pageable pageable);
	
}
