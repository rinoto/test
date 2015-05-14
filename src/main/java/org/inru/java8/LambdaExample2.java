package org.inru.java8;

public class LambdaExample2 {

	interface SayHiInterface {
		void sayHiTo(String name);
	}

	public static void method(SayHiInterface worker) {
		worker.sayHiTo("ruben");
	}

	public static void main(String[] args) {
		method(new SayHiInterface() {
			@Override
			public void sayHiTo(String name) {
				System.out.println("hi " + name);
			}
		});

		method(name -> System.out.println("hi " + name));

		// (p) is the String parameter passed to sayHiTo(String)
		SayHiInterface a = (p) -> System.out.println("hi " + p);
	}
}
