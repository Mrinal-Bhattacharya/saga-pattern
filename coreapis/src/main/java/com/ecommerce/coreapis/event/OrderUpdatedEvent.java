package com.ecommerce.coreapis.event;

public class OrderUpdatedEvent {
	
	public final String orderId;
	public final String orderStatus;

	public OrderUpdatedEvent(String orderId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}
}
