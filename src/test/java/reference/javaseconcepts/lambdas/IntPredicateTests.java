package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntPredicateTests {

    @Test
    public void intPredicate_1() {
        IntPredicate greaterThan100 = (i) -> i > 100;
        IntPredicate even = (i) -> i % 2 == 0;

        assertTrue(greaterThan100.test(200));
        assertTrue(greaterThan100.negate().test(50));
        assertTrue(greaterThan100.and(even).test(150));
        assertTrue(greaterThan100.or(even).test(50));
    }
}
