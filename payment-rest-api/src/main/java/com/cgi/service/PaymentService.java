package com.cgi.service;

import com.cgi.domain.request.PaymentRequest;
import com.cgi.domain.response.PaymentResponse;
import com.cgi.domain.response.SubmitPaymentResponse;

import java.util.List;

public interface PaymentService {

    public SubmitPaymentResponse submitPayment(PaymentRequest paymentRequest);
    public void updatePayment(PaymentRequest paymentRequest);
    public PaymentResponse getPaymentById(Long id);
    public List<PaymentResponse> getPayments();
}
