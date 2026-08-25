package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.Product;
import com.libreria_pedidos.libreria_api.serviceJPA.IProductService;
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
@RequestMapping ("/api/productos")
public class ProductController {
    @Autowired
    private IProductService productService;

    //METODO GET
    @GetMapping
    public ResponseEntity<DtoApiResponse <List<Product>>>  buscarTodosLosProductos() {
        List<Product> listaDeProductos = productService.buscarTodos();
        DtoApiResponse<List<Product>> response = new DtoApiResponse<>(200, "Productos encontrados", listaDeProductos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<Product>> buscarProductosPorId(@PathVariable Long id) {
        Product product = productService.buscarPorId(id);
        DtoApiResponse<Product> response = new DtoApiResponse<>(200, "Producto encontrado", product);
        return ResponseEntity.ok(response);
    }


    //METODO POST
    @PostMapping
    public ResponseEntity<DtoApiResponse<Product>> guardarProducto(@RequestBody Product product) {
        Product productoGuardado = productService.guardar(product);
        DtoApiResponse<Product> response = new DtoApiResponse<>(201, "Producto guardado", productoGuardado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //METODO PUT
    @PutMapping("/{id}")
    public ResponseEntity<DtoApiResponse<Product>> actualizarProducto(@RequestBody Product product, @PathVariable Long id) {
        Product productoActualizado = productService.actualizar(id, product);
        DtoApiResponse<Product> response = new DtoApiResponse<>(200, "Producto actualizado", productoActualizado);
        return ResponseEntity.ok(response);
    }

    //METODO DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<DtoApiResponse<Product>> eliminarProducto(@PathVariable Long id) {
        if (productService.existe(id)){
            productService.eliminar(id);
            DtoApiResponse<Product> dto = new DtoApiResponse<>(200, "Producto eliminado correctamente", null);
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<Product> dto = new DtoApiResponse<>(404, "El producto que intenta eliminar no existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }

    }
}
