package org.inru.java8;

public class LambdaExample4 {

	interface AdderInterface {
		int add(int a, int b);
	}

	public static void main(String[] args) {

		AdderInterface adder = (x, y) -> x + y;

		System.out.println(adder.add(1, 2));
	}
}
