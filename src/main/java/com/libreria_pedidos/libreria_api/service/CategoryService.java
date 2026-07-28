package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.model.Category;
import com.libreria_pedidos.libreria_api.repository.ICategoryRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository cRepo;
    //vamos a hacer lo mismo para las demas clases service, respetando el patron de diseño
    @Override
    public Category guardar(Category category) {
        return cRepo.save(category);
    }

    @Override
    public Category buscarPorId(Long id) {
        return cRepo.findById(id).orElse(null);
    }

    @Override
    public List<Category> buscarTodos() {
        return cRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        cRepo.deleteById(id);
    }

    @Override
    public Category actualizar(Long id, Category category) {
        return cRepo.save(category);
    }
}
