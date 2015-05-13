package org.inru.java8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MethodParameterReflectionExample {

	public void methodName(String paramName) {

	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method method = MethodParameterReflectionExample.class.getMethod("methodName", String.class);
		Parameter[] parameters = method.getParameters();

		// if option "-parameters" is used in javac, the method name is stored
		// in the compiled class, and we can obtain it via reflection!
		System.out.println(parameters[0].getName());

		// useful for:
		// @RequestMapping("/greeting")
		// public Greeting greeting(@RequestParam(value="name") String name) {
		// return new Greeting(counter.incrementAndGet(),
		// String.format(template, name));
		// }
	}

}
