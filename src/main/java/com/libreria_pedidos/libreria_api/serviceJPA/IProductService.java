package com.libreria_pedidos.libreria_api.service.serviceJPA;

import com.libreria_pedidos.libreria_api.model.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void delete(Long id);
    Product update(Long id, Product product);
}
