package reference.javaseconcepts.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test01_BigDecimal {
	
	@Test
	public void BigDecimalConstructors() {
		
		// Two BigDecimal objects are equal only if they are equal in value (variable intCompact, representing the absolute value of the significand) and scale (2.0 != 2.00)
		// significand = The number formed by the sign, the integer and the fraction (for "10.00", the significand will be 1000)
		BigDecimal bcFromInt = new BigDecimal(10);
		BigDecimal bcFromString = new BigDecimal("10.00");
 		BigDecimal bcFromCharArray = new BigDecimal( new char[]{'2', '1', '0'}, 1, 2, new MathContext(0));
		BigDecimal ten = BigDecimal.TEN;
		
		assertEquals(ten, bcFromInt);
		assertNotEquals(ten, bcFromString);
		assertEquals(ten, bcFromCharArray);
	}
}
