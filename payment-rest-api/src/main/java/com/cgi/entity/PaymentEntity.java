package com.cgi.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name=" PAYMENT")
@Data
public class PaymentEntity {
    @Id
    @Column(name= "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "ORDER_ID", nullable = false)
    private Long orderId;

    @Column(name= "STATUS", nullable = false)
    private String status;

    @Column(name= "AMOUNT", nullable = false)
    private BigDecimal amount;
}
