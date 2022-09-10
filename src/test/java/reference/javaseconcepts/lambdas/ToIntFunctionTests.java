package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ToIntFunctionTests {

    @Test
    public void toIntFunction_1() {
        ToIntFunction<String> stringToInt = (s) -> Integer.valueOf(s);

        assertThat(stringToInt.applyAsInt("20"), equalTo(20));
    }
}
