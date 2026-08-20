package com.libreria_pedidos.libreria_api.serviceJPA;

import com.libreria_pedidos.libreria_api.model.Category;
import java.util.List;

public interface ICategoryService {
    Category guardar(Category category);
    Category buscarPorId(Long id);
    List<Category> buscarTodos();
    void eliminar(Long id);
    Category actualizar(Long id, Category category);
    boolean existe(Long id);
}
