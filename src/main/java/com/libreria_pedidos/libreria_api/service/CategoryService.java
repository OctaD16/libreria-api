package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.exception.ResourceNotFoundException;
import com.libreria_pedidos.libreria_api.model.Category;
import com.libreria_pedidos.libreria_api.repository.ICategoryRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository cRepo;

    @Override
    public Category guardar(Category category) {
        return cRepo.save(category);
    }

    @Override
    public Category buscarPorId(Long id) {
        Optional<Category> cate = cRepo.findById(id);
        if (cate.isPresent()){
            return cate.get();
        }else{
            throw new ResourceNotFoundException("La categoria no existe");
        }
    }

    @Override
    public List<Category> buscarTodos() {
        return cRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        Category cate = this.buscarPorId(id);
        cRepo.delete(cate);
    }

    @Override
    public Category actualizar(Long id, Category category) {
        Category cate = this.buscarPorId(id);
        cate.setName(category.getName());
        cate.setDescription(category.getDescription());
        cate.setStatus(category.getStatus());
        return cRepo.save(category);
    }

    @Override
    public boolean existe(Long id) {
        return cRepo.existsById(id);
    }
}
