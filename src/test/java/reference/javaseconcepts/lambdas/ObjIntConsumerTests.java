package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjIntConsumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class ObjIntConsumerTests {

    @Test
    public void objIntConsumer_1() {
        List<String> list = new ArrayList<>();

        ObjIntConsumer<String> addToList = (s, i) -> list.add(s+i);

        addToList.accept("Integer number: ", 20);
        assertThat(list, contains("Integer number: 20"));
    }
}
