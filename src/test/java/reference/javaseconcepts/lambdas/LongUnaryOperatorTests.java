package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.LongUnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LongUnaryOperatorTests {

    @Test
    public void longUnaryOperator_1() {
        LongUnaryOperator add10 = (l) -> l+10;
        LongUnaryOperator multiplyBy10 = (l) -> l*10;

        assertThat(add10.applyAsLong(100), equalTo(110L));
        assertThat(add10.andThen(multiplyBy10).applyAsLong(10), equalTo(200L));
        assertThat(add10.compose(multiplyBy10).applyAsLong(10), equalTo(110L));
        assertThat(LongUnaryOperator.identity().applyAsLong(300), equalTo(300L));
    }
}
