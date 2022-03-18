package com.cgi.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name= "ORDERS")
@Data
public class OrderEntity {

    @Id
    @Column(name= "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name= "ORDER_STATUS", nullable = false)
    private String orderStatus;

}
