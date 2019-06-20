package com.ecommerce.saga;

import java.util.UUID;

import javax.inject.Inject;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import com.ecommerce.aggregates.OrderStatus;
import com.ecommerce.coreapis.command.CreateInvoiceCommand;
import com.ecommerce.coreapis.command.CreateShippingCommand;
import com.ecommerce.coreapis.command.UpdateOrderStatusCommand;
import com.ecommerce.coreapis.event.InvoiceCreatedEvent;
import com.ecommerce.coreapis.event.OrderCreatedEvent;
import com.ecommerce.coreapis.event.OrderShippedEvent;
import com.ecommerce.coreapis.event.OrderUpdatedEvent;

@Saga
public class OrderManagementSaga {

	@Inject
	private transient CommandGateway commandGateway;

	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderCreatedEvent orderCreatedEvent) {
		String paymentId = UUID.randomUUID().toString();
		System.out.println("Saga invoked");
		SagaLifecycle.associateWith("paymentId", paymentId);
		System.out.println("order id " + orderCreatedEvent.orderId);
		commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.orderId));
	}
	
	@SagaEventHandler(associationProperty = "paymentId")
    public void handle(InvoiceCreatedEvent invoiceCreatedEvent){
        String shippingId = UUID.randomUUID().toString();
        System.out.println("Saga continued");
        //associate Saga with shipping
        SagaLifecycle.associateWith("shipping", shippingId);
        //send the create shipping command
        commandGateway.send(new CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId, invoiceCreatedEvent.paymentId));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderShippedEvent orderShippedEvent){
        commandGateway.send(new UpdateOrderStatusCommand(orderShippedEvent.orderId, String.valueOf(OrderStatus.SHIPPED)));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderUpdatedEvent orderUpdatedEvent){
        SagaLifecycle.end();
    }
}