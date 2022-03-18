package com.cgi.mapper;

import com.cgi.domain.request.OrderRequest;
import com.cgi.entity.OrderEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

    public OrderEntity mapOrderRequestToOrderEntity(OrderRequest request);

}
