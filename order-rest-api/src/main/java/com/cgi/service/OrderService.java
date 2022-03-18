package com.cgi.service;

import com.cgi.domain.request.OrderRequest;
import com.cgi.domain.response.OrderResponse;

public interface OrderService {
    public void addOrder(OrderRequest request);
    public OrderResponse getOrderById(Long id);
}
