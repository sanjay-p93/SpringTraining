package com.spring.RestPoc.models;

public class Params {
	private double a;
	private double b;

	public Params() {
		super();
	}

	public Params(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

}
