package com.batch.BatchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.BatchProject.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
