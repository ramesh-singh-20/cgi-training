package com.cgi.controller;

import com.cgi.domain.request.OrderRequest;
import com.cgi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity submitOrder(@RequestBody OrderRequest request){
        service.addOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrderDetailsById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getOrderById(id));
    }

}
