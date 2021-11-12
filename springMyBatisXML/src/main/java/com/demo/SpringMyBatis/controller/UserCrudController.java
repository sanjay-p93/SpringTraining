package com.demo.SpringMyBatis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringMyBatis.mapper.UserMapper;
import com.demo.SpringMyBatis.model.User;

@RestController
@RequestMapping("/user/")
public class UserCrudController {

	@Autowired
	private UserMapper userMapper;

	private static final Logger log = LoggerFactory.getLogger(UserCrudController.class);

	@GetMapping("all")
	public List<User> getAll() {
		log.info("getAll");
		return userMapper.findAll();
	}

	@GetMapping("addnew")
	private List<User> insert() {
		User user = new User(27, "john@gmail", "james", "cam");
		userMapper.insert(user);
		return userMapper.findAll();
	}

	@GetMapping("update")
	private List<User> update() {
		User user = new User(27, "john@gmail", "john", "rambo");
		userMapper.update(user);
		return userMapper.findAll();
	}

	@GetMapping("delete")
	private List<User> delete() {
		User user = new User(27, "john@gmail", "john", "rambo");
		userMapper.deleteByMail(user);
		return userMapper.findAll();
	}

}
