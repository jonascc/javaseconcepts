package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntBinaryOperatorTests {

    @Test
    public void intBinaryOperator_1() {
        IntBinaryOperator sum = (o1, o2) -> o1 + o2;

        assertEquals(7, sum.applyAsInt(5, 2));
    }
}
