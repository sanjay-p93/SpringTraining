package com.demo.SpringMvcStudent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private FullName fullName;
	private String email;
	private Integer age;
	private String grade;

	public Student() {
	}

	public Student(Integer id, FullName fullName, String email, Integer age, String grade) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.age = age;
		this.grade = grade;
	}

	public Student(FullName fullName, String email, Integer age, String grade) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.age = age;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", email=" + email + ", age=" + age + ", grade=" + grade
				+ "]";
	}

}
