package com.cgi.service.impl;

import com.cgi.domain.client.ProductApiResponse;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final OrderMapper orderMapper;
    private final RestTemplate restTemplate;
    private final String GET_PRODUCTS_URL= "http://localhost:8085/products";
    private final String SUBMIT_PAYMENT_URL= "http://localhost:8085/payments";

    @Override
    public void addOrder(OrderRequest request) {
        OrderEntity orderEntity= orderMapper.mapOrderRequestToOrderEntity(request);

        BigDecimal amount= new BigDecimal(0.0);

        //call Payment API and set status accordingly
        for(ProductRequest productRequest: request.getProductRequests()){
            ProductApiResponse productApiResponse= restTemplate.
                    getForObject(GET_PRODUCTS_URL+ "/"+
                            productRequest.getProductId(), ProductApiResponse.class);
            amount= amount.add
                    (new BigDecimal
                            (productRequest.getQuantity())
                            .multiply(productApiResponse.getPrice()));
        }
        orderEntity.setAmount(amount);

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
        //String productURL= "http://localhost:8085/products";
        OrderResponse response= new OrderResponse();

        OrderEntity entity= orderRepository.getById(id);
        List<OrderProductEntity> orderProducts= orderProductRepository.findByOrderId(entity.getId());

        response.setId(entity.getId());
        response.setAmount(entity.getAmount());
        response.setStatus(entity.getOrderStatus());
        List<ProductResponse> products= new ArrayList<>();

        orderProducts.forEach(orderProduct -> {
            //call product-rest-api

            ProductApiResponse productApiResponseResponse=
                    restTemplate.getForObject(GET_PRODUCTS_URL+ "/"+
                            orderProduct.getProductId(), ProductApiResponse.class);

            ProductResponse productResponse= new ProductResponse();

            productResponse.setProductId(orderProduct.getProductId());
            productResponse.setName(productApiResponseResponse.getName());
            productResponse.setDescription(productApiResponseResponse.getDescription());
            productResponse.setPrice(productApiResponseResponse.getPrice());
            products.add(productResponse);
        });

        response.setProducts(products);

        return response;
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<OrderResponse> orderResponses= new ArrayList<>();

        List<OrderEntity> orderEntities= orderRepository.findAll();
        orderEntities.forEach(orderEntity -> {
            OrderResponse orderResponse= new OrderResponse();
            orderResponse.setId(orderEntity.getId());
            orderResponse.setAmount(orderEntity.getAmount());

            List<OrderProductEntity> orderProductEntities=
                    orderProductRepository.findByOrderId(orderEntity.getId());
            List<ProductResponse> productResponses= new ArrayList<>();

            orderProductEntities.forEach(orderProductEntity -> {
                ProductResponse productResponse= new ProductResponse();
                ProductApiResponse productApiResponse= restTemplate.
                        getForObject(GET_PRODUCTS_URL+ "/"+
                                orderProductEntity.getProductId(), ProductApiResponse.class);
                productResponse.setProductId(orderProductEntity.getProductId());
                productResponse.setName(productApiResponse.getName());
                productResponse.setDescription(productApiResponse.getDescription());
                productResponse.setPrice(productApiResponse.getPrice());
                productResponses.add(productResponse);
            });
            orderResponse.setProducts(productResponses);
            orderResponses.add(orderResponse);
        });
        return orderResponses;
    }
}
