package org.inru.java8;

public class LambdaExample3 {

	interface InterfaceWithOneMethod {
		String doSomething(String name);
	}

	public static void method(InterfaceWithOneMethod worker) {
		System.out.println(worker.doSomething("ruben"));
	}

	public static void main(String[] args) {
		method(new InterfaceWithOneMethod() {
			@Override
			public String doSomething(String name) {
				return "hi " + name;
			}
		});

		method(name -> "hi " + name);
	}
}
