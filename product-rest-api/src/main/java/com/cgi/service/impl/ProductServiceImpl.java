package com.cgi.service.impl;

import com.cgi.domain.request.ProductRequest;
import com.cgi.domain.response.ProductResponse;
import com.cgi.entity.ProductEntity;
import com.cgi.mapper.ProductMapper;
import com.cgi.repository.ProductRepository;
import com.cgi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__ ({@Autowired}))
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse getProductById(Long id) {
        Optional<ProductEntity> productEntityOptional= productRepository.findById(id);
        ProductResponse productResponse= null;
        if(productEntityOptional.isPresent()){
            productResponse= productMapper.mapProductEntityToProductResponse(productEntityOptional.get());
        }

        return productResponse;
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<ProductEntity> products= productRepository.findAll();
        List<ProductResponse> productResponses= new ArrayList<>();

        products.forEach(product-> productResponses.add(productMapper.
                mapProductEntityToProductResponse(product)));

        return productResponses;

    }

    @Override
    public void addProduct(ProductRequest request) {
        ProductEntity productEntity= productMapper.mapProductRequestToProductEntity(request);
        productRepository.save(productEntity);
    }

    @Override
    public void updateProduct(ProductRequest request) {
        ProductEntity productEntity= productMapper.mapProductRequestToProductEntity(request);
        productRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
