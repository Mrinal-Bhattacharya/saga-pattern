package com.ecommerce.coreapis.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateShippingCommand {

	@TargetAggregateIdentifier
	public final String shippingId;
	public final String orderId;
	public final String paymentId;

	public CreateShippingCommand(String shippingId, String orderId, String paymentId) {
		super();
		this.shippingId = shippingId;
		this.orderId = orderId;
		this.paymentId = paymentId;
	}

}
