package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjDoubleConsumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class ObjDoubleConsumerTests {

    @Test
    public void objDoubleConsumer_1() {
        List<String> list = new ArrayList<>();
        ObjDoubleConsumer<String> addToList = (s, d) -> list.add(s+d);

        addToList.accept("Double number: ", 20.0);
        assertThat(list, contains("Double number: 20.0"));
    }
}
