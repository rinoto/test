package org.inru.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

		// java8
		boolean allMatch = list.stream().allMatch(i -> i < 10);
		System.out.println(allMatch);

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

	public static void main(String[] args) {
		matching();
	}

}
