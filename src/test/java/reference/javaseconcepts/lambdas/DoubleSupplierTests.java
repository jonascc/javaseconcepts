package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleSupplierTests {

    @Test
    public void doubleSupplier_1() {
        DoubleSupplier doubleSupplier = () -> 10.0;

        assertEquals(10.0, doubleSupplier.getAsDouble());
    }
}
