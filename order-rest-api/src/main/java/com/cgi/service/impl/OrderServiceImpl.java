package com.cgi.service.impl;

import com.cgi.domain.request.OrderRequest;
import com.cgi.domain.request.ProductRequest;
import com.cgi.domain.response.OrderResponse;
import com.cgi.domain.response.ProductResponse;
import com.cgi.entity.OrderEntity;
import com.cgi.entity.OrderProductEntity;
import com.cgi.mapper.OrderMapper;
import com.cgi.repository.OrderProductRepository;
import com.cgi.repository.OrderRepository;
import com.cgi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final OrderMapper orderMapper;

    @Override
    public void addOrder(OrderRequest request) {
        OrderEntity orderEntity= orderMapper.mapOrderRequestToOrderEntity(request);
        //call Payment service and set status accordingly

        orderEntity.setAmount(new BigDecimal(2345.78));
        orderEntity.setOrderStatus("SUCCESS");
        orderRepository.save(orderEntity);

        //saving OrderProduct Entity
        for(ProductRequest productRequest : request.getProductRequests()){
            OrderProductEntity orderProduct= new OrderProductEntity();
            orderProduct.setOrder(orderEntity);
            orderProduct.setProductId(productRequest.getProductId());
            orderProduct.setQuantity(productRequest.getQuantity());
            orderProductRepository.save(orderProduct);
        }


    }

    @Override
    public OrderResponse getOrderById(Long id) {
        OrderResponse response= new OrderResponse();

        OrderEntity entity= orderRepository.getById(id);
        List<OrderProductEntity> orderProducts= orderProductRepository.findByOrderId(entity.getId());

        response.setId(entity.getId());
        response.setAmount(entity.getAmount());
        response.setStatus(entity.getOrderStatus());
        List<ProductResponse> products= new ArrayList<>();

        orderProducts.forEach(orderProduct -> {
            ProductResponse productResponse= new ProductResponse();
            productResponse.setProductId(orderProduct.getProductId());
            productResponse.setName("Product1");
            productResponse.setDescription("Description1");
            productResponse.setPrice(new BigDecimal(1234.67));
            products.add(productResponse);
        });

        response.setProducts(products);

        return response;
    }
}
