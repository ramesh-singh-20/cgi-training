package com.cgi.domain.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private BigDecimal amount;
    private String status;
    private List<ProductResponse> products;

}
