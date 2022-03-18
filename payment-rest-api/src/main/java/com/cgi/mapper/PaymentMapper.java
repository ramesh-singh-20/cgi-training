package com.cgi.mapper;

import com.cgi.domain.request.PaymentRequest;
import com.cgi.domain.response.PaymentResponse;
import com.cgi.domain.response.SubmitPaymentResponse;
import com.cgi.entity.PaymentEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentMapper {

    public PaymentEntity mapPaymentRequestToPaymentEntity(PaymentRequest request);
    public PaymentResponse mapPaymentEntityToPaymentResponse(PaymentEntity entity);
    @Mapping(target = "status", source = "status")
    public SubmitPaymentResponse mapStatusToSubmitPaymentResponse(String status);
}
