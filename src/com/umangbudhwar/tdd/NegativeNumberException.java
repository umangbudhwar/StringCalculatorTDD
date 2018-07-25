package com.umangbudhwar.tdd;

public class NegativeNumberException extends RuntimeException {
	private int num;

	public NegativeNumberException(int num) {
		this.num = num;
	}

	public String toString() {
		return "Negative Number Not Allowed " + num;
	}
}
