package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IntFunctionTests {

    @Test
    public void intFunction() {
        IntFunction<String> intToString = (i) -> String.valueOf(i);

        assertThat(intToString.apply(100), equalTo("100"));
    }
}
