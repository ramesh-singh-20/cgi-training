package com.cgi.domain.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductApiResponse implements Serializable {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
