package org.inru.java8.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderFixture {

	private static final AtomicInteger COUNTER = new AtomicInteger();
	private static final Random RANDOM = new Random();

	public static Order createOrder(OrderType orderType, int orderItemsCount) {

		Order o = new Order();
		o.id = "id_" + COUNTER.getAndIncrement();
		o.orderItems = createOrderItems(orderItemsCount);
		o.totalPrice = o.orderItems.stream().collect(Collectors.summingInt(x -> x.price));
		o.orderType = orderType;
		return o;

	}

	private static Collection<OrderItem> createOrderItems(int orderItemsCount) {
		Collection<OrderItem> oi = new ArrayList<>();
		for (int i = 0; i < orderItemsCount; i++) {
			oi.add(createOrderItem());
		}
		return oi;
	}

	private static OrderItem createOrderItem() {
		OrderItem oi = new OrderItem();
		oi.id = "orderItemId_" + COUNTER.getAndIncrement();
		oi.price = COUNTER.getAndIncrement();
		return oi;
	}
}
