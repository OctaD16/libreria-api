package com.libreria_pedidos.libreria_api.serviceJPA;

import com.libreria_pedidos.libreria_api.model.Category;
import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Category save(Category category);
    Optional<Category> findById(Long id);
    List<Category> findAll();
    void delete(Long id);
    Category update(Long id, Category category);
}
