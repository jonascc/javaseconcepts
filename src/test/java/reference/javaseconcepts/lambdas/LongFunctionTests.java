package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.LongFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LongFunctionTests {

    @Test
    public void longFunction_1() {
        LongFunction<String> longToString = (l) -> String.valueOf(l);

        assertThat(longToString.apply(10), equalTo("10"));
    }
}
