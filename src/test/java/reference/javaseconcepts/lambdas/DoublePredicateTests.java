package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.DoublePredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoublePredicateTests {

    @Test
    public void doublePredicate_1() {
        DoublePredicate isGreaterThan10 = d -> d > 10.0;

        assertTrue(isGreaterThan10.test(20.0));
        assertTrue(isGreaterThan10.negate().test(9.0));
    }

    @Test
    public void doublePredicate_2() {
        DoublePredicate isGreaterThan10 = d -> d > 10.0;

        DoublePredicate isEven = d -> d % 2 == 0;

        assertTrue(isGreaterThan10.and(isEven).test(20.0));
        assertFalse(isGreaterThan10.and(isEven).test(19.0));
        assertTrue(isGreaterThan10.or(isEven).test(19.0));
    }
}
