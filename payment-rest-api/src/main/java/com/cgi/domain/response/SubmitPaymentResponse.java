package com.cgi.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubmitPaymentResponse {
    private String status;
}
