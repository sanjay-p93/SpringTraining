package com.demo.SpringMVCPoc1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	private Integer id;
	private Integer age;
	private String email;
	private String firstName;
	private String lastName;

	public User() {
		super();
	}

	public User(Integer id, Integer age, String email, String firstName, String lastName) {
		super();
		this.id = id;
		this.age = age;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(Integer age, String email, String firstName, String lastName) {
		super();
		this.age = age;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "[ id=" + id + " | age=" + age + " | email=" + email + " | firstName=" + firstName + " | lastName="
				+ lastName + " ] \n";
	}
}
