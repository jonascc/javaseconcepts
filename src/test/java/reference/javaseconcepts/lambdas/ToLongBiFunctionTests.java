package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.ToLongBiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ToLongBiFunctionTests {

    @Test
    public void toLongBiFunction_1() {
        ToLongBiFunction<String, Integer> longSum = (s, i) -> Long.valueOf(s) + Long.valueOf(i);

        assertThat(longSum.applyAsLong("20", 5), equalTo(25L));
    }
}
