package org.inru.java8;

public class LambdaExample {

	interface InterfaceWithOneMethod {
		void doSomething();
	}

	public static void method(InterfaceWithOneMethod worker) {
		worker.doSomething();
	}

	public static void main(String[] args) {
		method(new InterfaceWithOneMethod() {
			@Override
			public void doSomething() {
				System.out.println("hi");
			}
		});

		method(() -> System.out.println("hi"));

		InterfaceWithOneMethod a = new InterfaceWithOneMethod() {

			@Override
			public void doSomething() {
				System.out.println("hola a");

			}
		};

		InterfaceWithOneMethod b = () -> System.out.println("hola b");

		a.doSomething();
		b.doSomething();
	}
}
