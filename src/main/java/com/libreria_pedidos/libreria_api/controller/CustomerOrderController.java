package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.CustomerOrder;
import com.libreria_pedidos.libreria_api.serviceJPA.ICustomerOrderService;
import com.libreria_pedidos.libreria_api.util.DtoApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Ordenes de clientes
@RestController
@RequestMapping("/api/ordenes")
public class CustomerOrderController {

    @Autowired
    private ICustomerOrderService customerOrderService;

    //METODO GET
    @GetMapping
    public ResponseEntity<DtoApiResponse<List<CustomerOrder>>> buscarTodos() {
        List<CustomerOrder> listaDeOrdenes = customerOrderService.buscarTodos();
        DtoApiResponse<List<CustomerOrder>> response = new DtoApiResponse<>(200, "Ordenes encontradas", listaDeOrdenes);
        return ResponseEntity.ok(response);
    }

    //METODO GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<CustomerOrder>> buscarPorId(@PathVariable Long id) {
        CustomerOrder customerOrder = customerOrderService.buscarPorId(id);
        DtoApiResponse<CustomerOrder> response = new DtoApiResponse<>(200, "Orden encontrada", customerOrder);
        return ResponseEntity.ok(response);
    }

    //METODO POST
    @PostMapping
    public ResponseEntity<DtoApiResponse<CustomerOrder>> guardar(@RequestBody CustomerOrder customerOrder) {
        CustomerOrder ordenGuardada = customerOrderService.guardar(customerOrder);
        DtoApiResponse<CustomerOrder> response = new DtoApiResponse<>(201, "Orden guardada", ordenGuardada);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //METODO PUT
    @PutMapping("/{id}")
    public ResponseEntity<DtoApiResponse<CustomerOrder>> actualizar(@RequestBody CustomerOrder customerOrder, @PathVariable Long id) {
        CustomerOrder ordenActualizada = customerOrderService.actualizar(id, customerOrder);
        DtoApiResponse<CustomerOrder> response = new DtoApiResponse<>(200, "Orden actualizada", ordenActualizada);
        return ResponseEntity.ok(response);
    }

    //METODO DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<DtoApiResponse<CustomerOrder>> eliminar(@PathVariable Long id) {
        if (customerOrderService.existe(id)){
            customerOrderService.eliminar(id);
            DtoApiResponse<CustomerOrder> dto = new DtoApiResponse<>(200, "", null);
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<CustomerOrder> dto = new DtoApiResponse<>(404, "", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }
}
