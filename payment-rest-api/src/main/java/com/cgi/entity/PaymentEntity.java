package com.cgi.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name=" PAYMENT")
public class PaymentEntity {
    @Id
    @Column(name= "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "ORDER_ID", nullable = false)
    private Long orderId;

    @Column(name= "status", nullable = false)
    private boolean status;

    @Column(name= "price", nullable = false)
    private BigDecimal price;
}
