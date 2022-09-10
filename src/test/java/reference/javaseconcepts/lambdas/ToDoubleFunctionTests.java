package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ToDoubleFunctionTests {

    @Test
    public void toDoubleFunction_1() {
        ToDoubleFunction<String> stringToDouble = (s) -> Double.parseDouble(s);

        assertThat(stringToDouble.applyAsDouble("30"), equalTo(30.0));
    }
}
