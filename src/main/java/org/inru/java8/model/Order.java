package org.inru.java8.model;

import java.util.Collection;

public class Order {

	public String id;
	public Collection<OrderItem> orderItems;
	public Integer totalPrice;
	public OrderType orderType;

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderItems=" + orderItems + ", totalPrice=" + totalPrice + ", orderType="
				+ orderType + "]";
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

}
