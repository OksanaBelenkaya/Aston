import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

@Test
void testCalculateFactorialZero() {
	assertEquals(1, FactorialCalculator.calculateFactorial(0));
}

@Test
void testCalculateFactorialPositive() {
	assertEquals(120, FactorialCalculator.calculateFactorial(5));
}

@Test
void testCalculateFactorialNegative() {
	assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculateFactorial(-1));
}
}