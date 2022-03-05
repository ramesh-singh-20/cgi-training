package com.cgi.endpoint;

import com.cgi.service.CalculatorService;
import com.cgi.spring.soap.api.calculator.CalculateRequest;
import com.cgi.spring.soap.api.calculator.CalculateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE= "http://www.cgi.com/spring/soap/api/calculator";
    @Autowired
    private CalculatorService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CalculateRequest")
    @ResponsePayload
    public CalculateResponse calculate(@RequestPayload CalculateRequest request){
        return service.calculate(request);
    }
}
