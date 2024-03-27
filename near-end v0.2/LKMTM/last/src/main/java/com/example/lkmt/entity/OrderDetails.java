//package com.example.lkmt.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "orderdetails")
//public class OrderDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long orderdetailsid;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "productId")
//    private Product product;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "OrderId")
//    private Orders order;
//
//    @Column(name = "quantity")
//    private int quantity;
//
//    @Column(name = "price")
//    private double price;
//}
