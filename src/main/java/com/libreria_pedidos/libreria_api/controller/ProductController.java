package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.Product;
import com.libreria_pedidos.libreria_api.serviceJPA.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/productos")
public class ProductController {
    @Autowired
    private IProductService productService;

    //METODO GET
    @GetMapping
    public List<Product> buscarTodos() {
        return productService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Product buscarPorId(@PathVariable Long id) {
        return productService.buscarPorId(id);
    }

    //METODO POST
    @PostMapping
    public Product guardar(@RequestBody Product product) {
        return productService.guardar(product);
    }

    //METODO PUT
    @PutMapping("/{id}")
    public Product actualizar(@PathVariable Long id, @RequestBody Product product) {
        return productService.actualizar(id, product);
    }

    //METODO DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productService.eliminar(id);
    }






}
