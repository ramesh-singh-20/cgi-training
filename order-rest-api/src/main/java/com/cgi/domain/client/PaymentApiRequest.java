package com.cgi.domain.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentApiRequest {
    private Long orderId;
    private BigDecimal amount;
}
