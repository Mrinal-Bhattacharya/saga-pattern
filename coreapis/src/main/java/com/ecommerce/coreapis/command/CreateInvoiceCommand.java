package com.ecommerce.coreapis.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateInvoiceCommand {

	@TargetAggregateIdentifier
	public final String paymentId;
	public final String orderId;
	
	public CreateInvoiceCommand(String paymentId, String orderId) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
	}
}