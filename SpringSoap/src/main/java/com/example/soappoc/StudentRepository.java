package com.example.soappoc;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.spring.soap_service.Student;

@Component
public class StudentRepository {
	private static final Map<String, Student> students = new HashMap<>();

	@PostConstruct
	public void initData() {
		Student john = new Student();
		john.setName("John Rambo");
		john.setBranch("CSE");
		john.setAge(21);

		students.put(john.getName(), john);

		Student rocky = new Student();
		rocky.setName("Rocky");
		rocky.setBranch("CSE");
		rocky.setAge(22);

		students.put(rocky.getName(), rocky);

		Student lisa = new Student();
		lisa.setName("Lisa");
		lisa.setBranch("EEE");
		lisa.setAge(24);

		students.put(lisa.getName(), lisa);

		Student luffy = new Student();
		luffy.setName("Luffy");
		luffy.setBranch("CSE");
		luffy.setAge(28);

		students.put(luffy.getName(), luffy);
	}

	public Student findStudent(String name) {
		Assert.notNull(name, "The student's name must not be null");
		return students.get(name);
	}
}
