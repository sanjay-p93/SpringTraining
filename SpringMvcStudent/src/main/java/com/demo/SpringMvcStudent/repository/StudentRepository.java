package com.demo.SpringMvcStudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SpringMvcStudent.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
