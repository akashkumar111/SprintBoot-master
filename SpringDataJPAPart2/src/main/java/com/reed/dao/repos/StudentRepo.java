package com.reed.dao.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.reed.dao.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {
	
	public List<Student> findByStudentNameAndStudentAge(String studentName,int studentAge);
	//Homework
	public List<Student> readFirst20ByStudentNameAndCity(String studentName,String city);
	public boolean existsByStudentName(String name);
	public int countByStudentName(String name);
	@Transactional
	public int deleteByStudentName(String name);

	
}
