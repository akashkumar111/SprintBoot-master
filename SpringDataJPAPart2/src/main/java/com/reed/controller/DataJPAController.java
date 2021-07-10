package com.reed.controller;

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

import com.reed.dao.entities.Student;
import com.reed.service.DataJPAService;

@RestController
public class DataJPAController {
	
	@Autowired
private	DataJPAService dataJPAService;

	@PostMapping("/students")
	public ResponseEntity<Object> saveAllStudents(@RequestBody List<Student> allStudents)
	{
		List<Student> savedStudents = dataJPAService.saveStudents(allStudents);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudents);
	}
	
	
	
	@GetMapping("/students")
	public ResponseEntity<Object> findAllStudents()
	{
		List<Student> allStudents = dataJPAService.findAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(allStudents);
	}
	
	@GetMapping("/students/count")
	public ResponseEntity<Object> findAllStudentsCount()
	{
		long count = dataJPAService.findAllStudentsCount();
		return ResponseEntity.status(HttpStatus.OK).body(count);
	}
	
	@GetMapping("/students/exists/{id}")
	public ResponseEntity<Object> existStudentById(@PathVariable long id)
	{
		boolean present = dataJPAService.existStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(present);
	}
	
	@DeleteMapping("/students/delete/{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable long id)
	{
		dataJPAService.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	
	@GetMapping("/sudents/method/{name}/{age}")
	public ResponseEntity<Object> findByStudentNameAndStudentAge(@PathVariable String name , @PathVariable int age)
	{
	List<Student> savedStudents= 	dataJPAService.findByStudentNameAndStudentAge(name, age);
	return ResponseEntity.status(HttpStatus.OK).body(savedStudents);
	}
	
	@GetMapping("/sudents/method/{name}")
	public ResponseEntity<Object> existsByStudentName(@PathVariable String name)
	{
	boolean present = 	dataJPAService.existsByStudentName(name);
	return ResponseEntity.status(HttpStatus.OK).body(present);
	}
	
	@GetMapping("/sudents/method/count/{name}")
	public ResponseEntity<Object> countByStudentName(@PathVariable String name)
	{
	int count = 	dataJPAService.countByStudentName(name);
	return ResponseEntity.status(HttpStatus.OK).body(count);
	}
	
	@GetMapping("/sudents/method/delete/{name}")
	public ResponseEntity<Object> deleteByStudentName(@PathVariable String name)
	{
	int deletedCount = 	dataJPAService.deleteByStudentName(name);
	return ResponseEntity.status(HttpStatus.OK).body(deletedCount);
	}
	
	
	
	
	
	
	
	
}
