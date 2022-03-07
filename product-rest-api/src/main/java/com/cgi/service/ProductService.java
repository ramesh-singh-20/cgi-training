package com.cgi.service;

import com.cgi.domain.request.ProductRequest;
import com.cgi.domain.response.ProductResponse;

import java.util.List;

public interface ProductService {

    public ProductResponse getProductById(Long id);
    public List<ProductResponse> getProducts();
    public void addProduct(ProductRequest request);
    public void updateProduct(ProductRequest request);
    public void deleteProduct(Long id);
}
