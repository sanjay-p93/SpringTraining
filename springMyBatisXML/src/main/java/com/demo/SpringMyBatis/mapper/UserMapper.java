package com.demo.SpringMyBatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.SpringMyBatis.model.User;

@Mapper
public interface UserMapper {

	List<User> findAll();

	void insert(User user);

	void update(User user);

	void deleteByMail(User user);

}
