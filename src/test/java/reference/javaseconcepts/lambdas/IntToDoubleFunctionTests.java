package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.IntToDoubleFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IntToDoubleFunctionTests {

    @Test
    public void intToDoubleFunction_1() {
        IntToDoubleFunction intToDouble = (i) -> Double.valueOf(i);

        assertThat(intToDouble.applyAsDouble(10), equalTo(10.0));
    }
}
