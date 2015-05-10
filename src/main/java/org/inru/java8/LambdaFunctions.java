package org.inru.java8;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunctions {

	public static void main(String[] args) {

		// we have a lot of predefined functions in package java.util.function
		// used in CompletableFuture.thenAppluc & thenCompose, Stream.map &
		// flatMap, ..
		Function<Integer, String> stringRepresentation = (i -> "string representation: " + i);

		String result = stringRepresentation.apply(42);
		System.out.println(result);

		// more examples
		// IntFunction is a function with a parameter of type Integer (result is
		// generic)
		IntFunction<String> stringRepresentation2 = (i -> "string representation: " + i);
		// predicate is a function without a result of type boolean (parameter
		// is generic)
		// used in List.removeIf, Stream.allMatch & filter, ...
		Predicate<Integer> biggerThanFive = (i -> i > 5);
		// consumes a parameter of generic type
		// used in Iterable.forEach, CompletableFuture.thenAccept, Stream.peek &
		// forEach, ...
		Consumer<String> printer = (s -> System.out.println(s));
		// function with two parameters
		BiFunction<Integer, Integer, Integer> sum = ((x, y) -> x + y);
		// function returning an Integer, and accepting no parameters
		// used in CompletableFuture.supplyAsync, ..
		Supplier<Integer> randomInt = (() -> new Random().nextInt());

	}
}
