package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BiPredicateTest {

    @Test
    public void biPredicate_1() {
        BiPredicate<String, String> areEmpty = (s1, s2) -> s1.isEmpty() && s2.isEmpty();

        assertTrue(areEmpty.test("", ""));
        assertFalse(areEmpty.negate().test("", ""));
        assertFalse(areEmpty.test("123", ""));
    }

    @Test
    public void biPredicate_2() {
        BiPredicate<String, String> areEmpty = (s1, s2) -> s1.isEmpty() && s2.isEmpty();
        BiPredicate<String, String> lengthThree = (s1, s2) -> s1.length() == 3 && s2.length() == 3;

        BiPredicate<String, String> emptyOrLengthThree = areEmpty.or(lengthThree);

        assertTrue(emptyOrLengthThree.test("", ""));
        assertTrue(emptyOrLengthThree.test("abc", "123"));
    }

    @Test
    public void biPredicate_3() {
        BiPredicate<String, String> endsWithA = (s1, s2) -> s1.endsWith("A") && s2.endsWith("A");
        BiPredicate<String, String> lengthThree = (s1, s2) -> s1.length() == 3 && s2.length() == 3;

        BiPredicate<String, String> lengthThreeAndEndsWithA = endsWithA.and(lengthThree);


        assertTrue(lengthThreeAndEndsWithA.test("AAA", "12A"));
        assertFalse(lengthThreeAndEndsWithA.test("123A", "abA"));
    }
}
