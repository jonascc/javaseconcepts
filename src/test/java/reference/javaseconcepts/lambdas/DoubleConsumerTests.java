package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleConsumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class DoubleConsumerTests {

    @Test
    public void doubleConsumer_1() {
        List<Double> greaterThan10 = new ArrayList<>();

        DoubleConsumer addGreaterThan10 = d -> {
            if (d > 10.0) {
                greaterThan10.add(d);
            }
        };

        addGreaterThan10.accept(20.0);
        assertThat(greaterThan10, hasSize(1));
    }

    @Test
    public void doubleConsumer_2() {
        List<Double> greaterThan10 = new ArrayList<>();

        DoubleConsumer addGreaterThan10 = d -> {
            if (d > 10.0) {
                greaterThan10.add(d);
            }
        };

        DoubleConsumer printGreaterThan10 = d -> {
            if (d > 10) {
                System.out.println(d);
            }
        };

        addGreaterThan10.andThen(printGreaterThan10).accept(20.0);
        assertThat(greaterThan10, hasSize(1));
    }
}
