package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicateTests {
	
	@Test
	public void predicate_1() {
		Predicate<String> isEmpty = String::isEmpty;
		
		Predicate<String> isNotEmpty = isEmpty.negate();
		
		assertTrue(isNotEmpty.test("Not empty!"));
		assertFalse(isNotEmpty.test(""));
	}
	
	@Test
	public void predicate_2() {
		Predicate<String> isNotNull = Objects::nonNull;
		Predicate<String> isEmpty = String::isEmpty;
		
		Predicate<String> isNotNullAndNotEmpty = isNotNull.and(isEmpty.negate());
		
		assertFalse(isNotNullAndNotEmpty.test(""));
		assertFalse(isNotNullAndNotEmpty.test(null));
		assertTrue(isNotNullAndNotEmpty.test("Not empty"));
	}

	@Test
	public void predicate_3() {
		Predicate<String> isNotNull = Objects::nonNull;
		Predicate<String> isEmpty = String::isEmpty;

		Predicate<String> isNotEmpty = Predicate.not(isEmpty);

		Predicate<String> isNotNullAndNotEmpty = isNotNull.and(isNotEmpty);

		assertFalse(isNotNullAndNotEmpty.test(""));
		assertFalse(isNotNullAndNotEmpty.test(null));
		assertTrue(isNotNullAndNotEmpty.test("Not empty"));
	}

	@Test
	public void predicate_4() {
		Predicate<String> isNull = Objects::isNull;
		Predicate<String> endsWithAAA = s -> s.endsWith("AAA");

		Predicate<String> isNullOrEndsWithAAA = isNull.or(endsWithAAA);

		assertTrue(isNullOrEndsWithAAA.test("AAA"));
		assertTrue(isNullOrEndsWithAAA.test(null));
		assertFalse(isNullOrEndsWithAAA.test("Not empty"));
	}

	@Test
	public void predicate_5() {
		String s = "AAA";
		Predicate<String> isEqualToAAA = Predicate.isEqual(s);

		assertTrue(isEqualToAAA.test("AAA"));
		assertFalse(isEqualToAAA.test("aaa"));
	}
}
