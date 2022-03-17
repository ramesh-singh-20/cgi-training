package com.cgi.service;

import com.cgi.domain.request.PaymentRequest;
import com.cgi.domain.response.PaymentResponse;

import java.util.List;

public interface PaymentService {

    public PaymentResponse submitPayment(PaymentRequest paymentRequest);
    public void updatePayment(PaymentRequest paymentRequest);
    public PaymentResponse getPaymentById(Long id);
    public List<PaymentResponse> getPayments();
}
