package com.cgi.domain.request;

import lombok.Data;

@Data
public class ProductRequest {
    private Long productId;
    private Integer quantity;
}
