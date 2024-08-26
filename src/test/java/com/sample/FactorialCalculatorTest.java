package com.sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialCalculatorTest {

@Test
public void testCalculateFactorialZero() {
	Assert.assertEquals(1, FactorialCalculator.calculateFactorial(0));
}

@Test
public void testCalculateFactorialPositive() {
	Assert.assertEquals(120, FactorialCalculator.calculateFactorial(5));
}

@Test(expectedExceptions = IllegalArgumentException.class)
public void testCalculateFactorialNegative() {
	FactorialCalculator.calculateFactorial(-1);
}
}