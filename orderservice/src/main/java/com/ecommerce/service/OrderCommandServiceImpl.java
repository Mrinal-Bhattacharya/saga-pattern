package com.ecommerce.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.ecommerce.aggregates.OrderStatus;
import com.ecommerce.coreapis.command.CreateOrderCommand;
import com.ecommerce.dto.OrderDTO;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

	private final CommandGateway commandGateway;

	public OrderCommandServiceImpl(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@Override
	public CompletableFuture<String> createOrder(OrderDTO orderDTO) {
		return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(), orderDTO.getItemType(),
				orderDTO.getPrice(), orderDTO.getCurrency(), String.valueOf(OrderStatus.CREATED)));
	}

}
