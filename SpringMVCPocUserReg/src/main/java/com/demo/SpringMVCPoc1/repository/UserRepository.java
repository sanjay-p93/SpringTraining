package com.demo.SpringMVCPoc1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SpringMVCPoc1.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByFirstName(String fisrtName);
}
