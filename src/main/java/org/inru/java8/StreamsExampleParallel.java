package org.inru.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExampleParallel {

	public static void parallelStream() {
		// create an infinite sequence of numbers from 0 -> the Natural numbers
		// and make it a parallel one
		Stream<Integer> naturalNumbers = Stream.iterate(0, i -> i + 1).parallel();

		List<Integer> collect = naturalNumbers.filter(i -> i % 2 == 0).map(i -> i / 2).limit(10)
				.collect(Collectors.toList());

		System.out.println(collect);
	}

	public static void main(String[] args) {
		parallelStream();
	}

}
