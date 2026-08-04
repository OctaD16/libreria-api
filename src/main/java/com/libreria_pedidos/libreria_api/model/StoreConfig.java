package com.libreria_pedidos.libreria_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class StoreConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String wappNumber;
    private String address;
    private String email;
    private String logo;
    private String favicon;
    private String currency;
    private boolean isOpen;
    private String openingHours;
    private String closingHours;
    private String deliveryHours;
    private String aliasStore;

}
