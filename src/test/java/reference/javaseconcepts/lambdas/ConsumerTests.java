package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class ConsumerTests {

	@Test
	public void consumer_1() {
		
		Consumer<List<String>> clearList = (List<String> strings) -> strings.clear();
		
		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		clearList.accept(list);
		
		assertThat(list, hasSize(0));
	}
	
	@Test
	public void consumer_2() {
		Consumer<List<String>> addFirst = list -> list.add("first");
		Consumer<List<String>> addSecond = list -> list.add("second");
		
		Consumer<List<String>> addFirstAndSecond = addFirst.andThen(addSecond);
		
		List<String> list = 
				new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		addFirstAndSecond.accept(list);
		
		assertThat(list, contains("a", "b", "c", "first", "second"));
	}
}
