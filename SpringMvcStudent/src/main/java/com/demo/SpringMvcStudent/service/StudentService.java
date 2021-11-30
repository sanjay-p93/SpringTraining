package com.demo.SpringMvcStudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringMvcStudent.model.Student;
import com.demo.SpringMvcStudent.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getall() {
		return studentRepository.findAll();
	}

	public Student add(Student student) {
		return studentRepository.save(student);
	}

	public void delete(int id) {
		studentRepository.deleteById(id);
		return;
	}

}
