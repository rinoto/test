package org.inru.java8;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalExample {

	private static void optionalWithValue() {
		Optional<String> hiString = Optional.of("hi");

		if (hiString.isPresent()) {
			System.out.println(hiString.get());
		} else {
			System.out.println("Optional is empty!");
		}
	}

	private static void optionalEmpty() {
		Optional<String> hiString = Optional.empty();

		if (hiString.isPresent()) {
			System.out.println(hiString.get());
		} else {
			System.out.println("Optional is empty!");
		}
	}

	private static void optionalEmptyWithException() {
		Optional<String> hiString = Optional.empty();

		System.out.println(hiString.get());
	}

	private static void optionalCombining() {
		Optional<String> hiString = Optional.of("hola");
		// Optional<String> hiString = Optional.empty();

		Consumer<String> printer = (s -> System.out.println(s));

		// execute the Consumer function only if the Optional holds a value
		hiString.ifPresent(s -> System.out.println(s));

		Optional<String> hiRuben = hiString.map(s -> s + " ruben");
		hiRuben.ifPresent(s -> System.out.println(s));

		Optional<String> filter = hiString.filter(s -> s.startsWith("hi"));
		filter.ifPresent(printer);

		hiString.orElse("hallo");
	}

	public static void main(String[] args) {
		optionalCombining();
	}

}
