package com.batch.BatchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.BatchProject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
