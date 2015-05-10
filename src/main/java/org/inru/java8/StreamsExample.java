package org.inru.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

	public static void filter() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// java
		List<Integer> filteredList = new ArrayList<Integer>();
		for (Integer i : list) {
			if (i < 3) {
				filteredList.add(i);
			}
		}
		System.out.println(filteredList);

		// java8
		List<Integer> collect = list.stream().filter(i -> i < 3).collect(Collectors.toList());
		System.out.println(collect);

	}

	public static void map() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// java
		List<Integer> plusOneList = new ArrayList<Integer>();
		for (Integer i : list) {
			plusOneList.add(i + 1);
		}
		System.out.println(plusOneList);

		// java8
		List<Integer> collect = list.stream().map(i -> i + 1).collect(Collectors.toList());
		System.out.println(collect);

	}

	public static void reduce() {

		Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);

		// sum of all the numbers using reduce(int, binaryOperator)
		Integer reduced = numbersStream.reduce(0, (x, y) -> x + y);
		System.out.println(reduced);

		numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
		Optional<Integer> reducedOptional = numbersStream.reduce((x, y) -> x + y);
		System.out.println(reducedOptional.get());
	}

	public static void flatMap() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// java
		List<List<Integer>> elementAndPlusOneListOfLists = new ArrayList<List<Integer>>();
		for (Integer i : list) {
			elementAndPlusOneListOfLists.add(Arrays.asList(i, i + 1));
		}
		List<Integer> flatList = new ArrayList<Integer>();
		for (List<Integer> integerSubList : elementAndPlusOneListOfLists) {
			flatList.addAll(integerSubList);
		}
		System.out.println(flatList);

		// java8
		List<Integer> collect = list.stream().flatMap(i -> Stream.of(i, i + 1)).collect(Collectors.toList());
		System.out.println(collect);

	}

	public static void matching() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// old way
		boolean allMatch = true;
		for (Integer i : list) {
			if (i >= 10) {
				allMatch = false;
				continue;
			}
		}
		System.out.println(allMatch);

		// java8
		// returns true if all elements in the stream match the predicate
		allMatch = list.stream().allMatch(i -> i < 10);
		System.out.println(allMatch);

		// anyMatch -> like allMatch, but returns true if at least one element
		// satisfies the predicate

	}

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

	public static void parallelStream() {
		// create an infinite sequence of numbers from 0 -> the Natural numbers
		// and make it a parallel one
		Stream<Integer> naturalNumbers = Stream.iterate(0, i -> i + 1).parallel();

		List<Integer> collect = naturalNumbers.filter(i -> i % 2 == 0).map(i -> i / 2).limit(10)
				.collect(Collectors.toList());

		System.out.println(collect);
	}

	public static void sortingStream() {
		// create an infinite sequence of numbers from 0 -> the Natural numbers
		// and make it a parallel one
		Stream<Integer> unsorted = Stream.of(2, 4, 1, 5, 7, 3);

		// see javadoc for java.util.Comparator<T>
		List<Integer> sortedList = unsorted.sorted((a, b) -> a - b).collect(Collectors.toList());

		System.out.println(sortedList);
	}

	public static void peek() {

		Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);

		// mainly for debugging - just sees the element that is beeing passed in
		// the stream to the next operation
		List<Integer> collect = numbersStream.peek(x -> System.out.println("beginning: " + x)).map((x) -> x + 1)
				.peek(x -> System.out.println("after map: " + x)).filter(x -> x < 5).collect(Collectors.toList());

		System.out.println(collect);

	}

	public static void main(String[] args) {
		peek();
	}

}
