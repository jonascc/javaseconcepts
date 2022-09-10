package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.IntToLongFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IntToLongFunctionTests {

    @Test
    public void intToLongFunction_1() {
        IntToLongFunction intToLong = (i) -> Long.valueOf(i);

        assertThat(intToLong.applyAsLong(10), equalTo(10L));
    }
}
