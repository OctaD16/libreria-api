package com.libreria_pedidos.libreria_api.serviceJPA;

import com.libreria_pedidos.libreria_api.model.Product;
import java.util.List;

public interface IProductService {
    Product guardar(Product product);
    Product buscarPorId(Long id);
    List<Product> buscarTodos();
    void eliminar(Long id);
    Product actualizar(Long id, Product product);
    public boolean existe(Long id);
}
