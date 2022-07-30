package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import reference.javaseconcepts.pojos.Person;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FunctionTests {

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
    public void composed_function_1() {
        Function<Person, String> toUpperCase = person -> person.getName().toUpperCase();
        Function<String, String> addPrefix = upperCaseName -> "Name: " + upperCaseName;

        Function<Person, String> toUpperCaseAndAddPrefix = addPrefix.compose(toUpperCase);

        List<String> names = people.stream()
                .map(toUpperCaseAndAddPrefix)
                .collect(Collectors.toList());

        assertThat(names, containsInAnyOrder("Name: JOHN", "Name: MARY", "Name: ADRIAN", "Name: DOUGLAS"));
    }

    @Test
    public void composed_function_2() {
        Function<Person, String> toUpperCase = person -> person.getName().toUpperCase();
        Function<String, String> addPrefix = upperCaseName -> "Name: " + upperCaseName;

        Function<Person, String> toUpperCaseAndAddPrefix = toUpperCase.andThen(addPrefix);

        List<String> names = people.stream()
                .map(toUpperCaseAndAddPrefix)
                .collect(Collectors.toList());

        assertThat(names, containsInAnyOrder("Name: JOHN", "Name: MARY", "Name: ADRIAN", "Name: DOUGLAS"));
    }

    @Test
    public void apply_1() {
        Function<Person, String> toLowerCase = person -> person.getName().toLowerCase();

        String name = toLowerCase.apply(person);

        assertThat(name, equalTo("anna"));
    }

    @Test
    public void identity_1() {
        Function<Person, Person> identity = Function.identity();

        Person person = identity.apply(this.person);

        assertThat(person, equalTo(this.person));
    }

}
