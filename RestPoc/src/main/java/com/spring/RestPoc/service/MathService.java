package com.spring.RestPoc.service;

import org.springframework.stereotype.Service;

import com.spring.RestPoc.models.Params;

@Service
public class MathService {

	public double add(Params param) {
		return param.getA() + param.getB();
	}

	public double sub(Params param) {
		return param.getA() - param.getB();
	}

	public double mul(Params param) {
		return param.getA() * param.getB();
	}

	public double div(Params param) {
		if (param.getB() != 0)
			return param.getA() / param.getB();
		return 0;
	}

	public double sqrt(double n) {
		if (n <= 0) {
			return 0;
		}
		return Math.sqrt(n);
	}
}
