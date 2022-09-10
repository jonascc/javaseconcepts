package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BinaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BinaryOperatorTests {

    @Test
    public void BinaryOperator_1() {
        BinaryOperator<String> bo = (name1, name2) -> name1 + " and " + name2 + ".";

        String str = bo.apply("Anne", "Emily");

        assertThat(str, equalTo("Anne and Emily."));
    }

    @Test
    public void BinaryOperator_2() {
        BinaryOperator<String> bo = BinaryOperator.maxBy(Comparator.comparingInt(String::length));

        String greaterLength = bo.apply("Anne", "Emily");

        assertThat(greaterLength, equalTo("Emily"));
    }

    @Test
    public void BinaryOperator_3() {
        BinaryOperator<String> bo = BinaryOperator.minBy(Comparator.comparingInt(String::length));

        String lesserLength = bo.apply("Anne", "Emily");

        assertThat(lesserLength, equalTo("Anne"));
    }
}
