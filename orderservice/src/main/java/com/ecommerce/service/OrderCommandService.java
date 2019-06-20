package com.ecommerce.service;

import java.util.concurrent.CompletableFuture;

import com.ecommerce.dto.OrderDTO;

public interface OrderCommandService {
    public CompletableFuture<String> createOrder(OrderDTO orderDTO);
}