package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.repository.ICategoryRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository cRepo;
    @Override
    public com.libreria_pedidos.libreria_api.model.Category save(com.libreria_pedidos.libreria_api.model.Category category) {
        return null;
    }

    @Override
    public java.util.Optional<com.libreria_pedidos.libreria_api.model.Category> findById(Long id) {
        return java.util.Optional.empty();
    }

    @Override
    public java.util.List<com.libreria_pedidos.libreria_api.model.Category> findAll() {
        return java.util.Collections.emptyList();
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public com.libreria_pedidos.libreria_api.model.Category update(Long id, com.libreria_pedidos.libreria_api.model.Category category) {
        return null;
    }
}
