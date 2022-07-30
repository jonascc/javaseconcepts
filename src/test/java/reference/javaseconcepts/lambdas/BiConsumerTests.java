package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class BiConsumerTests {

    @Test
    public void biConsumer_1() {
        BiConsumer<List<String>, String> addStringToList = (list, name) -> list.add(name);

        List<String> names = new ArrayList<>(Arrays.asList("John", "Anna"));

        addStringToList.accept(names, "Mary");

        assertThat(names, hasSize(3));
    }

    @Test
    public void biConsumer_2() {
        BiConsumer<List<String>, String> addStringToList = (list, name) -> list.add(name);
        BiConsumer<List<String>, String> addUpperCaseStringToList = (list, name) -> list.add(name.toUpperCase());

        List<String> names = new ArrayList<>(Arrays.asList("John", "Anna"));

        addStringToList.andThen(addUpperCaseStringToList).accept(names, "Mary");

        assertThat(names, hasSize(4));
    }

}
