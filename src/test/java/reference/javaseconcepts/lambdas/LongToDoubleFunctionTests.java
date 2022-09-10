package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.LongToDoubleFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LongToDoubleFunctionTests {

    @Test
    public void longToDoubleFunction_1() {
        LongToDoubleFunction longToDouble = (l) -> Double.valueOf(l);

        assertThat(longToDouble.applyAsDouble(10), equalTo(10.0));
    }
}
