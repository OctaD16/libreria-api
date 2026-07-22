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

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pro_id;
    private String pro_name; // Nombre del producto
    private String pro_description; // Descripción del producto
    private Double pro_price; // Precio del producto
    private Integer pro_stock; // Stock disponible
    private String pro_image; // URL de la imagen del producto
    private Integer pro_category; // Libro, Revista, etc.
    private String pro_status; // Activo, Inactivo
}
