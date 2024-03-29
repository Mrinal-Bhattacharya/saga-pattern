package com.ecommerce.coreapis.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateOrderStatusCommand {

	@TargetAggregateIdentifier
	public final String orderId;
	public final String orderStatus;

	public UpdateOrderStatusCommand(String orderId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}

}
