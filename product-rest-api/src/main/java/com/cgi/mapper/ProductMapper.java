package com.cgi.mapper;

import com.cgi.domain.request.ProductRequest;
import com.cgi.domain.response.ProductResponse;
import com.cgi.entity.ProductEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

    public ProductResponse mapProductEntityToProductResponse(ProductEntity entity);
    public ProductEntity mapProductRequestToProductEntity(ProductRequest request);

}
