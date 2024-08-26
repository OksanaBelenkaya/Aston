package org.example;

import com.sample.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

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