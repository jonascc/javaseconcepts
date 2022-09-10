package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import reference.javaseconcepts.pojos.Person;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BiFunctionTests {

    private List<Person> people;

    private Person person;

    @BeforeAll
    public void init() {
        people = List.of(
                new Person("John", 41),
                new Person("Mary", 25),
                new Person("Adrian", 12),
                new Person("Douglas", 25));

        person = new Person("Anna", 32);
    }

    @Test
    public void biFunction_1() {
        BiFunction<String, Integer, String> nameAndAge = (name, age) -> "Name: " + name + "; Age: " + age;

        String string = nameAndAge.apply(person.getName(), person.getAge());

        assertThat(string, equalTo("Name: Anna; Age: 32"));
    }

    @Test
    public void biFunction_2() {
        Function<String, String> toUpperCase = string -> string.toUpperCase();

        BiFunction<String, Integer, String> nameAndAge = (name, age) -> "Name: " + name + "; Age: " + age;

        String aggregate = nameAndAge.andThen(toUpperCase).apply(person.getName(), person.getAge());

        assertThat(aggregate, equalTo("NAME: ANNA; AGE: 32"));
    }
}
