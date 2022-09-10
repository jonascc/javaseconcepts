package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UnaryOperatorTests {

    @Test
    public void unaryOperator_1() {
        UnaryOperator<Integer> add10 = (i) -> i+10;
        UnaryOperator<Integer> multiplyBy10 = i -> i*10;

        assertThat(add10.apply(20), equalTo(30));
        assertThat(add10.andThen(multiplyBy10).apply(20), equalTo(300));
        assertThat(add10.compose(multiplyBy10).apply(20), equalTo(210));
        assertThat(UnaryOperator.identity().apply(10), equalTo(10));
    }
}
