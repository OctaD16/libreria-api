package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.exception.ResourceNotFoundException;
import com.libreria_pedidos.libreria_api.model.Product;
import com.libreria_pedidos.libreria_api.repository.IProductRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Product> pro = pRepo.findById(id);
        if (pro.isPresent()){
            return pro.get();
        }else{
            throw new ResourceNotFoundException("El producto no existe");
        }
    }

    @Override
    public List<Product> buscarTodos() {
        return pRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        Product product = this.buscarPorId(id);
        pRepo.delete(product);
    }

    @Override
    public Product actualizar(Long id, Product product) {
        Product prod = this.buscarPorId(id);

        prod.setName(product.getName());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());
        prod.setStock(product.getStock());
        prod.setImage(product.getImage());
        return pRepo.save(prod);
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
