package org.inru.java8;

import java.util.stream.Stream;

import org.inru.java8.model.Order;
import org.inru.java8.model.OrderFixture;
import org.inru.java8.model.OrderType;

public class StreamsExampleReduce {

	public static void sum() {

		Stream<Order> strStream = Stream.of(OrderFixture.createOrder(OrderType.RESERVATION, 4),
				OrderFixture.createOrder(OrderType.RESERVATION, 3), OrderFixture.createOrder(OrderType.PRODUCTION, 5));

		// sum of all the numbers using IntStream.sum()
		// sum() is not part of Stream, but of IntStream!
		Integer totalPrice = strStream.mapToInt(o -> o.totalPrice).sum();
		System.out.println(totalPrice);

	}

	/**
	 * sum of all the prices using reduce(int, binaryOperator)
	 * <p>
	 * <ul>
	 * <li>first parameter is called <b>identity</b>: the initial value of the
	 * reduction and the default result if there are no elements in the stream
	 * <li>second parameter is a BinaryOperator called <b>accumulator</b> that
	 * takes two elements (partialResult, currentElement), and returns the value
	 * that will be passed as partialResult to the next element of the stream.
	 * </ul>
	 * <p>
	 * e.g. multiply of elements of the stream
	 * <ul>
	 * <li>Stream: 5, 2, 4
	 * <li>reduceFunction: (1, (x,y) -> x*y)
	 * </ul>
	 * In Steps:
	 * <ul>
	 * <li>(1,5) -> 1*5 = 5
	 * <li>(5,2) -> 5*2 = 10
	 * <li>(10,4) -> 10*4 = 40
	 * <li>final result = 40
	 * </ul>
	 * The reduce operation always returns a new value.
	 */
	public static void reduce() {

		Stream<Order> strStream = Stream.of(OrderFixture.createOrder(OrderType.RESERVATION, 4),
				OrderFixture.createOrder(OrderType.RESERVATION, 3), OrderFixture.createOrder(OrderType.PRODUCTION, 5));

		Integer totalPrice = strStream.map(o -> o.totalPrice).reduce(0, (acc, thisPrice) -> acc + thisPrice);
		System.out.println(totalPrice);
	}

	public static void main(String[] args) {
		reduce();
	}

}
