package com.ecommerce.coreapis.event;

public class InvoiceCreatedEvent {
	
	public final String paymentId;
	public final String orderId;
	
	public InvoiceCreatedEvent(String paymentId, String orderId) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
	}
}
