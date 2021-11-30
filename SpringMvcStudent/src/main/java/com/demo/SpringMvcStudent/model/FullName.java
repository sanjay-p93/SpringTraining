package com.demo.SpringMvcStudent.model;

import javax.persistence.Embeddable;

@Embeddable
public class FullName {
	private String firstName;
	private String lastName;

	public FullName(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public FullName() {
		super();
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
		return "FullName [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
