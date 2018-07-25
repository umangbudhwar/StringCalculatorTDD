package com.umangbudhwar.tdd.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.umangbudhwar.tdd.NegativeNumberException;
import com.umangbudhwar.tdd.StringCalculator;

public class StringCalculatorTest {

	private static StringCalculator sc;

	@BeforeClass
	public static void beforeClass() {
		sc = new StringCalculator();
	}

	@Test
	public void testIfStringCalculatorClassExists() {
		assertNotNull(sc);
	}

	@Test
	public void testIfAddMethodExists() {
		sc.add("");
	}

	@Test
	public void testIfStringMethodReturnsInt() {
		int sum = sc.add("");
	}

	@Test
	public void testIfEmptyStringReturnsZero() {
		int sum = sc.add("");
		assertEquals(0, sum);
	}

	@Test
	public void testIfAddMethodReturnsSingleNumberCorrectly() {
		int sum = sc.add("12");
		assertEquals(12, sum);
	}

	@Test
	public void testIfAddMethodCanAddTwoNumbers() {
		int sum = sc.add("2,3");
		assertEquals(5, sum);
	}

	@Test
	public void testIfAddMethodCanAddUnknownAmountOfNumbers() {
		int sum = sc.add("2,3,4");
		assertEquals(9, sum);
	}

	@Test
	public void testIfAddMethodCanAddHandleNumbersInNewLines() {
		int sum = sc.add("2\n3,5");
		assertEquals(10, sum);
	}

	@Test
	public void testIfAddMethodSupportsDelimeter() {
		int sum = sc.add(";\n1;2");
		assertEquals(3, sum);
	}

	@Test(expected = NegativeNumberException.class)
	public void testIfAddMethodThrowsExceptionForSingleNegativeNumber() {
		int sum = sc.add("-2");
	}

	@Test(expected = NegativeNumberException.class)
	public void testIfAddMethodThrowsExceptionForNegativeNumbers() {
		int sum = sc.add("2\n-3,5");
	}

}
