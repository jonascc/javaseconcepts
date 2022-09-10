package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class IntConsumerTests {

    @Test
    public void intConsumer_1() {
        List<Integer> list = new ArrayList<>();

        IntConsumer addToList = (i) -> list.add(i);
        IntConsumer printList = (i) -> list.forEach(System.out::println);

        addToList.andThen(printList).accept(10);
        assertThat(list, hasSize(1));
    }
}
