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
    public ResponseEntity<DtoApiResponse<Product>> guardarProducto(@RequestBody Product product) {
        if (productService.existe(product.getId())){
            DtoApiResponse<Product> dto = new DtoApiResponse<>(404, "El producto que intenta guardar ya existe", null );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
         }else{
            DtoApiResponse<Product> dto = new DtoApiResponse<>(200, "Producto creado correctamente", productService.guardar(product));
            return ResponseEntity.ok().body(dto);
        }
    }

    //METODO PUT
    @PutMapping()
    public ResponseEntity<DtoApiResponse<Product>> actualizarProducto(@RequestBody Product product) {
        if (productService.existe(product.getId())){
            DtoApiResponse<Product> dto = new DtoApiResponse<>(200, "Producto actualizado correctamente", productService.guardar(product));
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<Product> dto = new DtoApiResponse<>(404, "El procucto que intenta actualizar no existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
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

//controladore de excepciones
/*
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<DtoApiResponse<?>> controladorDeExcepciones(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.add(violation.getMessage());
        }
        DtoApiResponse dto = new DtoApiResponse(400, errors, null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
*/


}
