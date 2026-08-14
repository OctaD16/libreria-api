package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.model.Product;
import com.libreria_pedidos.libreria_api.repository.IProductRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository pRepo;
    @Override
    public Product guardar(Product product){
        return pRepo.save(product);
    }

    @Override
    public Product buscarPorId (Long id)  {
        return pRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> buscarTodos() {
        return pRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        pRepo.deleteById(id);
    }

    @Override
    public Product actualizar(Long id, Product product) {
        return pRepo.save(product);
    }
    @Override
    public boolean existe(Long id) {
        if (id == null) {
            return false;
        } else {
            return pRepo.existsById(id);
        }
    }
}
