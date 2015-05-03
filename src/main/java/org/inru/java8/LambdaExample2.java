package org.inru.java8;

public class LambdaExample2 {

	interface InterfaceWithOneMethod {
		void doSomething(String name);
	}

	public static void method(InterfaceWithOneMethod worker) {
		worker.doSomething("ruben");
	}

	public static void main(String[] args) {
		method(new InterfaceWithOneMethod() {
			@Override
			public void doSomething(String name) {
				System.out.println("hi " + name);
			}
		});

		method(name -> System.out.println("hi " + name));
	}
}
