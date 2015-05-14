package org.inru.java8;

public class LambdaExample {

	interface SayHiInterface {
		void sayHi();
	}

	public static void method(SayHiInterface c) {
		c.sayHi();
	}

	public static void main(String[] args) {
		method(new SayHiInterface() {
			@Override
			public void sayHi() {
				System.out.println("hi");
			}
		});

		method(() -> System.out.println("hi"));

		SayHiInterface a = new SayHiInterface() {

			@Override
			public void sayHi() {
				System.out.println("hola a");

			}
		};

		// bind methods to variables! (code as data)
		SayHiInterface b = () -> System.out.println("hola b");

		a.sayHi();
		b.sayHi();
		method(b);
	}
}
