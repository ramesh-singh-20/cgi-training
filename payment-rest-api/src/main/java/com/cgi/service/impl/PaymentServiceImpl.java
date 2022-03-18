package com.cgi.service.impl;

import com.cgi.domain.request.PaymentRequest;
import com.cgi.domain.response.PaymentResponse;
import com.cgi.domain.response.SubmitPaymentResponse;
import com.cgi.entity.PaymentEntity;
import com.cgi.mapper.PaymentMapper;
import com.cgi.repository.PaymentRepository;
import com.cgi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;

    @Override
    public SubmitPaymentResponse submitPayment(PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity= paymentMapper.mapPaymentRequestToPaymentEntity(paymentRequest);
        boolean status= generatePaymentStatus();


        if(status){
            paymentEntity.setStatus("SUCCESS");
        }else{
            paymentEntity.setStatus("FAILURE");
        }
        paymentRepository.save(paymentEntity);

       return paymentMapper.mapStatusToSubmitPaymentResponse(paymentEntity.getStatus());

    }

    @Override
    public void updatePayment(PaymentRequest paymentRequest) {
        paymentRepository.save(paymentMapper.mapPaymentRequestToPaymentEntity(paymentRequest));
    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        PaymentResponse response= null;
        Optional<PaymentEntity> paymentOptional= paymentRepository.findById(id);

        if(paymentOptional.isPresent()){
            response= paymentMapper.mapPaymentEntityToPaymentResponse(paymentOptional.get());
        }

        return response;
    }

    @Override
    public List<PaymentResponse> getPayments() {
        List<PaymentResponse> payments= new ArrayList<>();

        List<PaymentEntity> paymentEntities= paymentRepository.findAll();

        if(paymentEntities!= null && paymentEntities.size()>0){
            paymentEntities.forEach(payment ->
                    payments.add(paymentMapper.mapPaymentEntityToPaymentResponse(payment)));
        }

        return payments;

    }

    //Utility method to generate payment status
    private boolean generatePaymentStatus(){
        Random random= new Random();
        return random.nextBoolean();
    }
}
