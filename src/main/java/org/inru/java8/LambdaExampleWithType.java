package org.inru.java8;

import java.util.Comparator;

public class LambdaExampleWithType {

	public static void typeInLambdaExpression() {

		Comparator<Integer> c = (Integer x, Integer y) -> {
			return x + y;
		};
	}

}
