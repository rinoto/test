package org.inru.java8;

import java.util.Comparator;

public class LambdaExampleNoShadowing {

	public static void noShadowing() {
		int a = 24;

		Comparator<Integer> c = (x, y) -> {
			// int a;
			return x + y;
		};
	}

}
