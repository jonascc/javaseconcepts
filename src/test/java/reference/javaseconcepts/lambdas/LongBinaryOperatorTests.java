package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.LongBinaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LongBinaryOperatorTests {

    @Test
    public void longBinaryOperator_1() {
        LongBinaryOperator sum = (l1, l2) -> l1+l2;

        assertThat(sum.applyAsLong(10, 100), equalTo(110L));
    }
}
