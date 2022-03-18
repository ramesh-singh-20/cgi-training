package com.cgi.controller;

import com.cgi.domain.request.PaymentRequest;
import com.cgi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @GetMapping
    public ResponseEntity getPayments(){
        return ResponseEntity.
                status(HttpStatus.OK).body(service.getPayments());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity getPaymentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getPaymentById(id));
    }

    @PostMapping
    public ResponseEntity submitPayment(@RequestBody PaymentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.submitPayment(request));
    }

    @PutMapping
    public ResponseEntity updatePayment(@RequestBody PaymentRequest request) {
        service.updatePayment(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
