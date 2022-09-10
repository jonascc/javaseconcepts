package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleFunctionTests {

    @Test
    public void DoubleFunction() {
        DoubleFunction<String> greaterThan10 = d -> {
            if (d > 10.0) {
                return d + " is greater than 10.0";
            }
            return "";
        };

        String isGreaterThan10 = greaterThan10.apply(20.0);
        assertEquals("20.0 is greater than 10.0", isGreaterThan10);
    }
}
