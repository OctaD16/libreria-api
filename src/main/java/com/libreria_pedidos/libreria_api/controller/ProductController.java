package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.Product;
import com.libreria_pedidos.libreria_api.serviceJPA.IProductService;
import com.libreria_pedidos.libreria_api.util.DtoApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/productos")
public class ProductController {
    @Autowired
    private IProductService productService;

    //METODO GET
    @GetMapping
    public ResponseEntity<DtoApiResponse <List<Product>>>  buscarTodosLosProductos() {
        List<Product> listaDeProductos = productService.buscarTodos();
        if (listaDeProductos == null || listaDeProductos.isEmpty()){
            DtoApiResponse dto = new DtoApiResponse(404, "No hay productos", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }else {
            DtoApiResponse dto = new DtoApiResponse(200, "Productos encontrados", listaDeProductos);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<Product>> buscarProductosPorId(@PathVariable Long id) {
        if(productService.existe(id)){
            DtoApiResponse<Product> dto = new DtoApiResponse<>(200, "Producto encontrado", productService.buscarPorId(id));
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse dto = new DtoApiResponse(404, "Producto no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }

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
