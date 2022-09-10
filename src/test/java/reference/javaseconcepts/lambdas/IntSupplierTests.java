package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IntSupplierTests {

    @Test
    public void intSupplier() {
        IntSupplier intNumber = () -> 10;

        assertThat(intNumber.getAsInt(), equalTo(10));
    }
}
