package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjLongConsumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class ObjLongConsumerTests {

    @Test
    public void objLongConsumer_1() {
        List<String> list = new ArrayList<>();
        ObjLongConsumer<String> addToList = (s, l) -> list.add(s+l);

        addToList.accept("Long number: ", 10L);
        assertThat(list, contains("Long number: 10"));
    }
}
