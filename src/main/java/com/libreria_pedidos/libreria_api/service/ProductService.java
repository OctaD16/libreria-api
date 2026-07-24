package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.repository.IProductRepository;
import com.libreria_pedidos.libreria_api.service.serviceJPA.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository pRepo;
    @Override
    public com.libreria_pedidos.libreria_api.model.Product save(com.libreria_pedidos.libreria_api.model.Product product) {
        return null;
    }

    @Override
    public java.util.Optional<com.libreria_pedidos.libreria_api.model.Product> findById(Long id) {
        return java.util.Optional.empty();
    }

    @Override
    public java.util.List<com.libreria_pedidos.libreria_api.model.Product> findAll() {
        return java.util.Collections.emptyList();
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public com.libreria_pedidos.libreria_api.model.Product update(Long id, com.libreria_pedidos.libreria_api.model.Product product) {
        return null;
    }
}
