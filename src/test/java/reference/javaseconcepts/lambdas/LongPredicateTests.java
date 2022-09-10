package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.LongPredicate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongPredicateTests {

    @Test
    public void longPredicate_1() {
        LongPredicate greaterThan10 = (l) -> l > 10L;
        LongPredicate even = (l) -> l % 2 == 0;

        assertTrue(greaterThan10.test(20));
        assertTrue(greaterThan10.negate().test(5));
        assertTrue(greaterThan10.and(even).test(20));
        assertTrue(greaterThan10.or(even).test(2));
    }
}
