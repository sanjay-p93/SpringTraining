package com.cal.service;

import org.springframework.stereotype.Service;

import com.cal.model.InputNum;

@Service
public class CalService {

	public double add(InputNum inputNum) {
		return inputNum.getNum1() + inputNum.getNum2();
	}

	public double subtract(InputNum inputNum) {
		return inputNum.getNum1() - inputNum.getNum2();
	}

	public double multiply(InputNum inputNum) {
		return inputNum.getNum1() * inputNum.getNum2();
	}

	public double divide(InputNum inputNum) {
		return inputNum.getNum1() / inputNum.getNum2();
	}


}
