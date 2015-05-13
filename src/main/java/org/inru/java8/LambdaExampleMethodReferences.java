package org.inru.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExampleMethodReferences {

	public static int addOne(int n) {
		return n + 1;
	}

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2, 3);

		// adding one
		// stream.map(i -> i + 1);

		// adding one with method reference
		List<Integer> collect = stream.map(LambdaExampleMethodReferences::addOne).collect(Collectors.toList());
		System.out.println(collect);
	}
}
