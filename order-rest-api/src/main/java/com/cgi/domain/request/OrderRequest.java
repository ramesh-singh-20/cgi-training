package com.cgi.domain.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequest {
    private Long id;
    private BigDecimal amount;
    private List<ProductRequest> products;
}
