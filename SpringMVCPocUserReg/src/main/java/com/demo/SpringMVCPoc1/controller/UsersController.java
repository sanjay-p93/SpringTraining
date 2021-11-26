package com.demo.SpringMVCPoc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.SpringMVCPoc1.repository.UserRepository;

@Controller
public class UsersController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/getbyname")
	public String sayHello(@RequestParam("name") String name, Model model) {

		model.addAttribute("list", userRepository.findByFirstName(name));
		return "userlist";
	}

	@GetMapping("/getall")
	public String getAll(Model model) {
		model.addAttribute("list", userRepository.findAll());
		return "userlist";
	}
}
