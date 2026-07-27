package com.libreria_pedidos.libreria_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.apache.bcel.generic.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

    private Integer stock;

    private String image;

    private int status; // 1 = Activo, 0 = Inactivo

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_config_id")
    private StoreConfig storeConfig;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrdersDetail> ordersDetails;

    @ManyToMany
    private List<Product> products;


}
