package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.ToLongFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ToLongFunctionTests {

    @Test
    public void toLongFunction_1() {
        ToLongFunction<String> stringToLong = (s) -> Long.valueOf(s);

        assertThat(stringToLong.applyAsLong("50"), equalTo(50L));
    }
}
