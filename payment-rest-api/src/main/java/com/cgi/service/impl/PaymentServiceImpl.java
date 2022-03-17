package com.cgi.service.impl;

import com.cgi.domain.request.PaymentRequest;
import com.cgi.domain.response.PaymentResponse;
import com.cgi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class PaymentServiceImpl implements PaymentService {

    //private final pa
    @Override
    public PaymentResponse submitPayment(PaymentRequest paymentRequest) {
        return null;
    }

    @Override
    public void updatePayment(PaymentRequest paymentRequest) {

    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        return null;
    }

    @Override
    public List<PaymentResponse> getPayments() {
        return null;
    }
}
