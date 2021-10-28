package com.spring.RestPoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.RestPoc.models.Params;

@RestController
@RequestMapping("/restTemplate")
public class MathRestTemplateController {

	@Autowired
	RestTemplate restTemplate;

	String url = "http://localhost:8080/math/";

	@PostMapping("/add")
	public double add(@RequestBody Params params) {
		ResponseEntity<Double> response = restTemplate.postForEntity(url + "add", params,
				Double.class);
		return response.getBody();
	}

	@PostMapping("/sub")
	public double sub(@RequestBody Params params) {
		ResponseEntity<Double> response = restTemplate.postForEntity(url + "sub", params,
				Double.class);
		return response.getBody();
	}

	@PostMapping("/mul")
	public double mul(@RequestBody Params params) {
		ResponseEntity<Double> response = restTemplate.postForEntity(url + "mul", params,
				Double.class);
		return response.getBody();
	}

	@PostMapping("/div")
	public double div(@RequestBody Params params) {
		ResponseEntity<Double> response = restTemplate.postForEntity(url + "div", params,
				Double.class);
		return response.getBody();

	}

	@GetMapping("/sqrt/{n}")
	public double sqrtNum(@PathVariable double n) {
		String uri = url + "sqrt/" + n;
		double sqrt = restTemplate.getForObject(uri, Double.class);
		return sqrt;
	}

}
