package com.libreria_pedidos.libreria_api.controller;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.libreria_pedidos.libreria_api.model.Category;
import com.libreria_pedidos.libreria_api.serviceJPA.ICategoryService;
import com.libreria_pedidos.libreria_api.util.DtoApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
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
    @GetMapping
    public ResponseEntity<DtoApiResponse<List<Category>>> buscarCategorias() {
        List<Category> listaDeCategorias = categoryService.buscarTodos();
        if (listaDeCategorias.isEmpty()){
            DtoApiResponse<List<Category>> dto = new DtoApiResponse<>(404, "no hay categorias que mostrar", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }else {
           DtoApiResponse<List<Category>> dto = new DtoApiResponse<>(200, "", listaDeCategorias);
           return ResponseEntity.status(HttpStatus.OK).body(dto);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<Category>> buscarPorId(@PathVariable Long id) {
        Category category = categoryService.buscarPorId(id);
        if(category != null){
            DtoApiResponse<Category> dto = new DtoApiResponse<>(200, "", category);
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<Category> dto = new DtoApiResponse<>(404, "La categoria no existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }

    //METODO POST
    @PostMapping
    public ResponseEntity<DtoApiResponse<Category>> guardarCategoria(@RequestBody Category category) {
        if(categoryService.existe(category.getId())){
            DtoApiResponse<Category> dto = new DtoApiResponse<>(404, "Ya existe la categoria", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
        }else {
            Category categoriaGuardada = categoryService.guardar(category);
            DtoApiResponse<Category> dto = new DtoApiResponse<>(200, "", categoriaGuardada);
            return ResponseEntity.ok().body(dto);
        }
    }

    //METODO PUT
    @PutMapping("/{id}")
    public ResponseEntity<DtoApiResponse<Category>> actualizarCategoria(@RequestBody Category category) {
        if (categoryService.existe(category.getId())){
          DtoApiResponse<Category> dto = new DtoApiResponse<>(200, "", category);
          return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<Category> dto = new DtoApiResponse<>(404, "La categoria no existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }

    //METODO DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<DtoApiResponse<String>> eliminarCategoria(@PathVariable Long id) {
        if (categoryService.existe(id)){
            categoryService.eliminar(id);
            DtoApiResponse<String> dto = new DtoApiResponse<>(200, "Eliminada correctamente", null);
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<String> dto = new DtoApiResponse<>(404, "La categoria no existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }
}
