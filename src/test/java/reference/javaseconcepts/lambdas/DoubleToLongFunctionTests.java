package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleToLongFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleToLongFunctionTests {

    @Test
    public void doubleToLongFunction_1() {
        DoubleToLongFunction remainder = d -> (long) d % 2;

        assertEquals(1, remainder.applyAsLong(9.0));
    }
}
