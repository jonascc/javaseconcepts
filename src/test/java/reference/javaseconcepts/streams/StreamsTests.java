package reference.javaseconcepts.streams;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import reference.javaseconcepts.pojos.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StreamsTests {

    List<Person> people;

    @BeforeAll
    public void init() {
        people = List.of(
                new Person("John", 41),
                new Person("Mary", 25),
                new Person("Adrian", 12),
                new Person("Douglas", 25));
    }

    @Test
    public void map_1() {
        Function<Person, String> toUpperCase = person -> person.getName().toUpperCase();

        List<String> upperCaseNames = people.stream()
                .map(toUpperCase)
                .collect(Collectors.toList());

        assertThat(upperCaseNames, containsInAnyOrder("JOHN", "MARY", "ADRIAN", "DOUGLAS"));
    }

    @Test
    public void mapToInt_1() {
        ToIntFunction<Person> getPersonAge = person -> person.getAge();

        // TODO Add explanation on the collect method
        List<Integer> ages = people.stream()
                .mapToInt(getPersonAge)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        assertThat(ages, containsInAnyOrder(41, 25, 12, 25));
    }

    @Test
    public void mapToInt_2() {
        // Using method reference
        List<Integer> ages = people.stream()
                .mapToInt(Person::getAge)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        assertThat(ages, containsInAnyOrder(41, 25, 12, 25));
    }
}
