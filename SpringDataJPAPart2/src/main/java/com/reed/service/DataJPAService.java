package com.reed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reed.dao.entities.Student;
import com.reed.dao.repos.StudentRepo;

@Service
public class DataJPAService {

	@Autowired
	private StudentRepo studentRepo;
		
	public List<Student> saveStudents(List<Student> allStudents)
	{
		List<Student> 	savedAllStudents = (List<Student>) studentRepo.saveAll(allStudents);
		return savedAllStudents;
	}
	
	public List<Student> findAllStudents()
	{
		List<Student> 	allStudents = (List<Student>) studentRepo.findAll();
		return allStudents;
	}

	public long findAllStudentsCount() {
	return	studentRepo.count();
		
	}

	public boolean existStudentById(long id) {
		return studentRepo.existsById(id);
	}

	public void deleteStudentById(long id) {
		studentRepo.deleteById(id);
		
	}
	
	
	
	public List<Student> findByStudentNameAndStudentAge(String name,int age)
	{
		return studentRepo.findByStudentNameAndStudentAge(name, age);
	}

	public boolean existsByStudentName(String name) {
		return studentRepo.existsByStudentName(name);
	}

	public int countByStudentName(String name) {
		return studentRepo.countByStudentName(name);
	}

	public int deleteByStudentName(String name) {
		return studentRepo.deleteByStudentName(name);
	}

	
	
}
