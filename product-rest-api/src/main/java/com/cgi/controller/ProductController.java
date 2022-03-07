package com.cgi.controller;

import com.cgi.domain.request.ProductRequest;
import com.cgi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/products")
@RequiredArgsConstructor(onConstructor = @__ ({@Autowired}))
public class ProductController {
    private final ProductService service;

    @GetMapping
    public ResponseEntity getProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getProducts());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity getProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getProductById(id));
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductRequest request){
        service.addProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProductRequest request) {
        service.updateProduct(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
