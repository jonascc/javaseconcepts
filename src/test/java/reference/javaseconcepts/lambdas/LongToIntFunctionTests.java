package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.LongToIntFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LongToIntFunctionTests {

    @Test
    public void longToIntFunction() {
        LongToIntFunction remainder = (l) -> (int) l % 2;

        assertThat(remainder.applyAsInt(121), equalTo(1));
    }
}
