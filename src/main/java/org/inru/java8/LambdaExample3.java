package org.inru.java8;

public class LambdaExample3 {

	interface SayHiInterface {
		String sayHiToAndReturnString(String name);
	}

	public static void method(SayHiInterface worker) {
		System.out.println(worker.sayHiToAndReturnString("ruben"));
	}

	public static void main(String[] args) {
		method(new SayHiInterface() {
			@Override
			public String sayHiToAndReturnString(String name) {
				return "hi " + name;
			}
		});

		method(name -> "hi " + name);
		method(name -> {
			return "hi " + name;
		});
	}
}
