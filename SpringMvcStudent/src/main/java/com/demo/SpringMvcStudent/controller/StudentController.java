package com.demo.SpringMvcStudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.SpringMvcStudent.model.Student;
import com.demo.SpringMvcStudent.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String showIndex(Model model) {
		return "index";
	}

	@GetMapping("/students")
	public String getAll(Model model) {
		model.addAttribute("students", studentService.getall());
		return "studentList";
	}

	@GetMapping("/add")
	public String addForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Student student, Model model) {
		studentService.add(student);
		return "index";
	}

	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable int id, Model model) {
		studentService.delete(id);
		model.addAttribute("students", studentService.getall());
		return "redirect:/students";
	}
}
