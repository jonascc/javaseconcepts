package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.LongSupplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LongSupplierTests {

    @Test
    public void longSupplier_1() {
        LongSupplier longSupplier = () -> 100;

        assertThat(longSupplier.getAsLong(), equalTo(100L));
    }
}
