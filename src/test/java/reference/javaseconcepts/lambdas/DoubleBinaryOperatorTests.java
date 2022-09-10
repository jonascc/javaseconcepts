package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleBinaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DoubleBinaryOperatorTests {

    @Test
    public void DoubleBinaryOperator() {
        DoubleBinaryOperator dbo = (val1, val2) -> val1 + val2;

        double sum = dbo.applyAsDouble(1.0, 2.0);

        assertThat(sum, equalTo(3.0));
    }
}
