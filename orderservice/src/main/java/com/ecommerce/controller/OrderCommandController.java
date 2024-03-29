package com.ecommerce.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.OrderDTO;
import com.ecommerce.service.OrderCommandService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/orders")
@Api(value = "Order Commands", description = "Order Commands Related Endpoints", tags = "Order Commands")
public class OrderCommandController {
	
	
	private OrderCommandService orderCommandService;
	
	public OrderCommandController(OrderCommandService orderCommandService) {
		this.orderCommandService = orderCommandService;
	}
	@PostMapping
	public CompletableFuture<String> createOrder(@RequestBody OrderDTO orderDTO){
		return orderCommandService.createOrder(orderDTO);
	}
	
	@GetMapping
	public String hello() {
		return "hello";
	}

}
