package reference.javaseconcepts.lambdas;

import java.util.Objects;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Test02_Predicate {
	
	@Test
	public void predicate_1() {
		Predicate<String> predicate = s -> s.isEmpty();
		
		Predicate<String> notPredicate = predicate.negate();
		
		assertTrue(notPredicate.test("Not empty!"));
		assertFalse(notPredicate.test(""));
	}
	
	@Test
	public void predicate_2() {
		Predicate<String> p1 = Objects::nonNull;
		Predicate<String> p2 = String::isEmpty;
		
		Predicate<String> p3 = p1.and(p2.negate());
		
		assertFalse(p3.test(""));
		assertFalse(p3.test(null));
		assertTrue(p3.test("Not empty"));
		
		double valor = 0.2;
		double total = 0;
		for (int i = 0; i < 10; i++) {
			total += valor;
		}
		System.out.println(total);
		
	}
	

}
