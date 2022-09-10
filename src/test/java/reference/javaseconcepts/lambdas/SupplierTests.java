package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SupplierTests {

    @Test
    public void supplier_1() {
        Supplier<String> stringSupplier = () -> "Test string";

        assertThat(stringSupplier.get(), equalTo("Test string"));
    }
}
