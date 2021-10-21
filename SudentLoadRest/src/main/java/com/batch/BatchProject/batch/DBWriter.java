package com.batch.BatchProject.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batch.BatchProject.model.Student;
import com.batch.BatchProject.repository.StudentRepository;


@Component
public class DBWriter implements ItemWriter<Student> {

	private StudentRepository studentRepository;

    @Autowired
	public DBWriter(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
    }

    @Override
	public void write(List<? extends Student> students) throws Exception {
		studentRepository.saveAll(students);
    }
}
