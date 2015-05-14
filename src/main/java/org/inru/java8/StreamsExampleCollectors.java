package org.inru.java8;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.inru.java8.model.Order;
import org.inru.java8.model.OrderFixture;
import org.inru.java8.model.OrderType;

/**
 * The method Stream.collect() performs a mutable reduction operation on the
 * elements of this stream using a Collector (the Stream.reduce always creates a
 * new value, the Stream.collect() <b>modifies</b> an existing value)
 * 
 * @author rinoto
 *
 */
public class StreamsExampleCollectors {

	private static void count() {
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);

		Long numberOfElements = intStream.collect(Collectors.counting());
		System.out.println(numberOfElements);
	}

	private static void concat() {
		Stream<String> strStream = Stream.of("a", "b", "c", "d");

		String concat = strStream.collect(Collectors.joining("-"));
		System.out.println(concat);
	}

	private static void sum() {
		Stream<Order> strStream = Stream.of(OrderFixture.createOrder(OrderType.RESERVATION, 4),
				OrderFixture.createOrder(OrderType.RESERVATION, 3), OrderFixture.createOrder(OrderType.PRODUCTION, 5));

		Integer totalSum = strStream.collect(Collectors.summingInt(o -> o.totalPrice));
		System.out.println(totalSum);
	}

	private static void concatWithOwnCollectorUsingCollectorMethodWithInterface() {
		Stream<String> strStream = Stream.of("a", "b", "c", "d");

		String concat = strStream.collect(new Collector<String, StringBuilder, String>() {

			// creates the container
			@Override
			public Supplier<StringBuilder> supplier() {
				return (() -> new StringBuilder());
			}

			// adds the value to the container
			@Override
			public BiConsumer<StringBuilder, String> accumulator() {
				return ((sb, s) -> {
					sb.append(s);
					sb.append("#");
				});
			}

			// only for parallel?
			@Override
			public BinaryOperator<StringBuilder> combiner() {
				return ((sb, sb2) -> sb.append(sb2));
			}

			// transforms the intermediate result to a final one
			@Override
			public Function<StringBuilder, String> finisher() {
				return ((sb) -> sb.toString());
			}

			@Override
			public Set<java.util.stream.Collector.Characteristics> characteristics() {
				return Collections.emptySet();
			}
		});
		System.out.println(concat);
	}

	private static void concatWithOwnCollectorUsingCollectorMethodWithLambdas() {
		Stream<String> strStream = Stream.of("a", "b", "c", "d");

		StringBuilder concat = strStream.collect(StringBuilder::new, // supplier
				(sb, s) -> {
					sb.append(s);
					sb.append("#");
				}, // accumulator
				(sb, sb2) -> sb.append(sb2) // combiner
				);
		System.out.println(concat.toString());
	}

	private static void average() {
		// Integers
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);

		Double average = intStream.collect(Collectors.averagingInt(x -> x));
		System.out.println(average);

		// Orders
		Stream<Order> orderStream = Stream.of(OrderFixture.createOrder(OrderType.RESERVATION, 2),
				OrderFixture.createOrder(OrderType.RESERVATION, 3), OrderFixture.createOrder(OrderType.PRODUCTION, 1));

		average = orderStream.collect(Collectors.averagingInt(o -> o.totalPrice));
		System.out.println(average);

	}

	static class TotalCountHolder {
		private int total = 0;
		private int count = 0;

		public void add(int i) {
			total += i;
			count++;
		}

		public TotalCountHolder combine(TotalCountHolder other) {
			total += other.total;
			count += other.count;
			return this;
		}
	}

	private static void averageWithOwnCollector() {
		Stream<Order> orderStream = Stream.of(OrderFixture.createOrder(OrderType.RESERVATION, 2),
				OrderFixture.createOrder(OrderType.RESERVATION, 3), OrderFixture.createOrder(OrderType.PRODUCTION, 1));

		Double average = orderStream.collect(new Collector<Order, TotalCountHolder, Double>() {

			@Override
			public Supplier<TotalCountHolder> supplier() {
				return TotalCountHolder::new;
			}

			@Override
			public BiConsumer<TotalCountHolder, Order> accumulator() {
				return ((avg, o) -> avg.add(o.totalPrice));
			}

			@Override
			public BinaryOperator<TotalCountHolder> combiner() {
				return ((avg1, avg2) -> avg1.combine(avg2));
			}

			@Override
			public Function<TotalCountHolder, Double> finisher() {
				return (holder -> {
					if (holder.count <= 0) {
						return 0.0;
					}
					return ((double) holder.total) / holder.count;
				});
			}

			@Override
			public Set<java.util.stream.Collector.Characteristics> characteristics() {
				return Collections.emptySet();
			}

		});
		System.out.println(average);
	}

	private static void grouping() {
		Stream<Order> orderStream = Stream.of(OrderFixture.createOrder(OrderType.RESERVATION, 0),
				OrderFixture.createOrder(OrderType.RESERVATION, 0), OrderFixture.createOrder(OrderType.PRODUCTION, 0));

		Map<OrderType, List<Order>> groupOrders = orderStream.collect(Collectors.groupingBy(o -> o.orderType));
		System.out.println(groupOrders);
	}

	private static void groupingWithAverage() {
		Stream<Order> orderStream = Stream.of(OrderFixture.createOrder(OrderType.RESERVATION, 1),
				OrderFixture.createOrder(OrderType.RESERVATION, 4), OrderFixture.createOrder(OrderType.PRODUCTION, 2));

		Map<OrderType, Double> collect = orderStream.collect(Collectors.groupingBy(o -> o.orderType,
				Collectors.averagingInt(Order::getTotalPrice)));
		System.out.println(collect);
	}

	public static void main(String[] args) {
		groupingWithAverage();
	}

}
