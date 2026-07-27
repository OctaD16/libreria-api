package com.libreria_pedidos.libreria_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Integer  role;
    private Integer status;

@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_config_id")
    private StoreConfig storeConfig;
}
