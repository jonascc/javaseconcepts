package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleUnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleUnaryOperatorTests {

    @Test
    public void doubleUnaryOperator_1() {
        DoubleUnaryOperator times10 = d -> d*10;

        assertEquals(190.0, times10.applyAsDouble(19.0));
    }

    @Test
    public void doubleUnaryOperator_2() {
        DoubleUnaryOperator times10 = d -> d*10;

        DoubleUnaryOperator plus2 = d -> d+2;

        assertEquals(102.0, times10.andThen(plus2).applyAsDouble(10.0));
        assertEquals(120.0, times10.compose(plus2).applyAsDouble(10.0));
    }
}
