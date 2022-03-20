package com.cgi.service;

import com.cgi.domain.request.OrderRequest;
import com.cgi.domain.response.OrderResponse;

import java.util.List;

public interface OrderService {
    public void addOrder(OrderRequest request);
    public OrderResponse getOrderById(Long id);
    public List<OrderResponse> getAllOrders();
}
