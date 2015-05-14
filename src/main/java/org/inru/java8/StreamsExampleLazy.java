package org.inru.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExampleLazy {

	public static void streamIsLazy() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// java8
		Stream<Integer> stream = list.stream().map(i -> {
			System.out.println("element: " + i);
			return i;
		});
		System.out.println("stream has been created");
		System.out.println("start collecting");
		stream.collect(Collectors.toList());
		System.out.println("Collect finished");

	}

	public static void infinitStream() {
		// create an infinite sequence of numbers from 0 -> the Natural numbers
		Stream<Integer> naturalNumbers = Stream.iterate(0, i -> i + 1);

		List<Integer> collect = null;

		// limit - gets the first ten
		collect = naturalNumbers.limit(10).collect(Collectors.toList());

		// skip - gets 10 from the 5th
		// collect =
		// naturalNumbers.skip(5).limit(10).collect(Collectors.toList());

		// limit comes AFTER the filtering
		// collect = naturalNumbers.filter(i -> i % 2 ==
		// 0).limit(10).collect(Collectors.toList());

		// collect = naturalNumbers.filter(i -> i % 2 == 0).map(i -> i /
		// 2).limit(10).collect(Collectors.toList());

		System.out.println(collect);
	}

	public static void main(String[] args) {
		streamIsLazy();
	}

}
