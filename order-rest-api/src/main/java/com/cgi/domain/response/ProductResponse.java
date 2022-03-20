package com.cgi.domain.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
