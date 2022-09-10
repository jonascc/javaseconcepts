package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleBiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ToDoubleBiFunctionTests {

    @Test
    public void toDoubleBiFunction_1() {
        ToDoubleBiFunction<Integer, Integer> doubleSum = (i1, i2) -> Double.valueOf(i1+i2);

        assertThat(doubleSum.applyAsDouble(10, 5), equalTo(15.0));
    }
}
