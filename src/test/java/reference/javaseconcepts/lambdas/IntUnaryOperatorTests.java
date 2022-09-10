package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IntUnaryOperatorTests {

    @Test
    public void intUnaryOperator_1() {
        IntUnaryOperator sum10 = (i) -> i+10;
        IntUnaryOperator multiplyBy10 = (i) -> i*10;

        assertThat(sum10.applyAsInt(10), equalTo(20));
        assertThat(sum10.andThen(multiplyBy10).applyAsInt(10), equalTo(200));
        assertThat(sum10.compose(multiplyBy10).applyAsInt(10), equalTo(110));
        assertThat(IntUnaryOperator.identity().applyAsInt(100), equalTo(100));
    }
}
