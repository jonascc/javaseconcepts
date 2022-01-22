package reference.javaseconcepts.lambdas;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import org.junit.jupiter.api.Test;

public class Test01_Consumer {

	@Test
	public void consumer_1() {
		
		Consumer<List<String>> consumer = (List<String> strings) -> strings.clear();
		
		List<String> list = 
				new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		consumer.accept(list);
		
		assertThat(list, hasSize(0));
	}
	
	@Test
	public void consumer_2() {
		Consumer<List<String>> c1 = list -> list.add("first");
		Consumer<List<String>> c2 = list -> list.add("second");
		
		Consumer<List<String>> consumer = c1.andThen(c2);
		
		List<String> list = 
				new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		consumer.accept(list);
		
		assertThat(list, contains("a", "b", "c", "first", "second"));
	}
}
