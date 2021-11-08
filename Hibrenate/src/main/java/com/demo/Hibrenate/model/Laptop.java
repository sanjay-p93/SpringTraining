package com.demo.Hibrenate.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Laptop {
	@Id
	private Integer id;
	private String model;
	private Integer year;

	public Laptop(Integer id, String model, Integer year) {
		super();
		this.id = id;
		this.model = model;
		this.year = year;
	}

	public Laptop() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", model=" + model + ", year=" + year + "]";
	}

}
