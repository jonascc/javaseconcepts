package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntBiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ToIntBiFunctionTests {

    @Test
    public void toIntBiFunction_1() {
        ToIntBiFunction<String, Integer> intSum = (s, i) -> Integer.valueOf(s) + i;

        assertThat(intSum.applyAsInt("30", 2), equalTo(32));
    }
}
