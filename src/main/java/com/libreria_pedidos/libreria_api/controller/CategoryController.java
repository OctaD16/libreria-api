package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.Category;
import com.libreria_pedidos.libreria_api.serviceJPA.ICategoryService;
import com.libreria_pedidos.libreria_api.util.DtoApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    //METODO GET
    //All
    @GetMapping
    public ResponseEntity<DtoApiResponse<List<Category>>> buscarCategorias() {
        List<Category> listaDeCategorias = categoryService.buscarTodos();
        DtoApiResponse<List<Category>> response = new DtoApiResponse<>(200, "Categorias encontradas", listaDeCategorias);
        return ResponseEntity.ok(response);
        }
    //By id
    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<Category>> buscarPorId(@PathVariable Long id) {
        Category category = categoryService.buscarPorId(id);
        DtoApiResponse<Category> response = new DtoApiResponse<>(200, "Categoria encontrada", category);
        return ResponseEntity.ok(response);
    }

    //METODO POST
    @PostMapping
    public ResponseEntity<DtoApiResponse<Category>> guardarCategoria(@RequestBody Category category) {
        Category categoriaGuardada = categoryService.guardar(category);
        DtoApiResponse<Category> response = new DtoApiResponse<>(201, "Categoria guardada", categoriaGuardada);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //METODO PUT
    @PutMapping("/{id}")
    public ResponseEntity<DtoApiResponse<Category>> actualizarCategoria(@RequestBody Category category, @PathVariable Long id) {
    Category categoriaActualizada = categoryService.actualizar(id, category);
    DtoApiResponse<Category> response = new DtoApiResponse<>(200, "Categoria actualizada", categoriaActualizada);
    return ResponseEntity.ok(response);
    }

    //METODO DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<DtoApiResponse<String>> eliminarCategoria(@PathVariable Long id) {
    categoryService.eliminar(id);
    DtoApiResponse<String> response = new DtoApiResponse<>(200, "Categoria eliminada", null);
    return ResponseEntity.ok(response);
    }
}
