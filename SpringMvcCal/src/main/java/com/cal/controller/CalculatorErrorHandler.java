package com.cal.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CalculatorErrorHandler {


	@ExceptionHandler({ Exception.class })
	public String notFountGlobal(Exception e) {
		System.out.println(e.getClass());
		return "error";
	}

}