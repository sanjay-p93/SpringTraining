package com.spring.RestPoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.RestPoc.models.Params;
import com.spring.RestPoc.service.MathService;

@RestController
@RequestMapping("/math")
public class MathRestController {

	@Autowired
	MathService mathService;

	@PostMapping("/add")
	public double add(@RequestBody Params params) {
		return mathService.add(params);

	}

	@PostMapping("/sub")
	public double sub(@RequestBody Params params) {
		return mathService.sub(params);

	}

	@PostMapping("/mul")
	public double mul(@RequestBody Params params) {
		return mathService.mul(params);

	}

	@PostMapping("/div")
	public double div(@RequestBody Params params) {
		return mathService.div(params);

	}

	@GetMapping("/sqrt/{n}")
	public double findById(@PathVariable double n) {
		return mathService.sqrt(n);
	}

}
