package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleToIntFunctionTests {

    @Test
    public void doubleToIntFunction_1() {
        DoubleToIntFunction remainder = d -> (int) d % 2;

        assertEquals(1, remainder.applyAsInt(9.0));
    }
}
