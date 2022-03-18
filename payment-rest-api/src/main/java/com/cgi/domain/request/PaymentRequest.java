package com.cgi.domain.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequest {
    private Long id;
    private Long orderId;
    private BigDecimal amount;
    private String status;

}
