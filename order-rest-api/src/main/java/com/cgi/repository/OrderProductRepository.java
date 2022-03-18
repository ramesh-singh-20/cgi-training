package com.cgi.repository;

import com.cgi.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> {

    public List<OrderProductEntity> findByOrderId(Long orderId);
}
