package com.pranavdesai.OrderService.service;

import com.pranavdesai.OrderService.model.OrderRequest;

public interface OrderService {
    public long placeOrder(OrderRequest orderRequest);
}
