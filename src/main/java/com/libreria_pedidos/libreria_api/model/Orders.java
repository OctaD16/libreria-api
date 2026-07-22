package com.libreria_pedidos.libreria_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String customerName;

    private String address;

    private String phone;

    private String email;

    private double total;

    private Integer paymentMethod;

    private Integer status;

    private String observations;

    private Integer deliveryType;

    private LocalDateTime deliveryDate;







}
