package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongConsumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class LongConsumerTests {

    @Test
    public void longConsumer_1() {
        List<Long> list = new ArrayList<>();
        LongConsumer addToList = (l) -> list.add(l);
        LongConsumer print = System.out::println;

        addToList.andThen(print).accept(10);

        assertThat(list, hasSize(1));
    }
}
