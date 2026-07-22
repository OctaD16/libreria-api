package com.libreria_pedidos.libreria_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ord_id;
    private String ord_date;
    private String ord_customer_name; // Nombre del Cliente
    private String ord_address;
    private String ord_phone;
    private String ord_email;
    private double ord_total;
    private Integer ord_payment;
    private Integer ord_status;
    private String ord_observations;







}
