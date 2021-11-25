package com.cal.model;

public class CalResult {
	private String message;
	private double value;

	public CalResult() {
		super();
	}

	public CalResult(String message, double value) {
		super();
		this.message = message;
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CalResult [message=" + message + ", value=" + value + "]";
	}

}
