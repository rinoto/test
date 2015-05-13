package org.inru.java8;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

	private static void count() {
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);

		Long numberOfElements = intStream.collect(Collectors.counting());
		System.out.println(numberOfElements);
	}

	private static void concat() {
		Stream<String> strStream = Stream.of("a", "b", "c", "d");

		String concat = strStream.collect(Collectors.joining("-"));
		System.out.println(concat);
	}

	private static void concatWithOwnCollector() {
		Stream<String> strStream = Stream.of("a", "b", "c", "d");

		String concat = strStream.collect(new Collector<String, StringBuilder, String>() {

			// creates the container
			@Override
			public Supplier<StringBuilder> supplier() {
				return (() -> new StringBuilder());
			}

			// adds the value to the container
			@Override
			public BiConsumer<StringBuilder, String> accumulator() {
				return ((sb, s) -> {
					sb.append(s);
					sb.append("#");
				});
			}

			// only for parallel?
			@Override
			public BinaryOperator<StringBuilder> combiner() {
				return ((sb, sb2) -> sb.append(sb2));
			}

			// transforms the intermediate result to a final one
			@Override
			public Function<StringBuilder, String> finisher() {
				return ((sb) -> sb.toString());
			}

			@Override
			public Set<java.util.stream.Collector.Characteristics> characteristics() {
				return Collections.emptySet();
			}
		});
		System.out.println(concat);
	}

	private static void average() {
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);

		Double average = intStream.collect(Collectors.averagingInt(x -> x));
		System.out.println(average);
	}

	public static void main(String[] args) {
		concatWithOwnCollector();
	}

}
