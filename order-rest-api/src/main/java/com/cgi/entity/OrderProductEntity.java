package com.cgi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "ORDER_PRODUCT")
@Data
public class OrderProductEntity {

    @Id
    @Column(name= "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;

    @Column(name= "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name= "QUANTITY", nullable = false)
    private Integer quantity;
}
