package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.Category;
import com.libreria_pedidos.libreria_api.serviceJPA.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    //METODO GET
    @GetMapping
    public List<Category> buscarTodos() {
        return categoryService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Category buscarPorId(@PathVariable Long id) {
        return categoryService.buscarPorId(id);
    }

    //METODO POST
    @PostMapping
    public Category guardar(@RequestBody Category category) {
        return categoryService.guardar(category);
    }

    //METODO PUT
    @PutMapping("/{id}")
    public Category actualizar(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.actualizar(id, category);
    }

    //METODO DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        categoryService.eliminar(id);
    }




}
