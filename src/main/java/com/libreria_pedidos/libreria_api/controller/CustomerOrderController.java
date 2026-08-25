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
        if (listaDeOrdenes == null || listaDeOrdenes.isEmpty()){
            DtoApiResponse dto = new DtoApiResponse(404, "No hay ordenes", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }else {
            DtoApiResponse dto = new DtoApiResponse<>(200, "", listaDeOrdenes);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }
    }

    //METODO GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<CustomerOrder>> buscarPorId(@PathVariable Long id) {
        if (customerOrderService.existe(id)){
            DtoApiResponse<CustomerOrder> dto = new DtoApiResponse(200, "", customerOrderService.buscarPorId(id));
             return ResponseEntity.status(HttpStatus.OK).body(dto);
        }else{
            DtoApiResponse dto = new DtoApiResponse(404, "", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }

    }

    //METODO POST
    @PostMapping
    public ResponseEntity<DtoApiResponse> guardar(@RequestBody CustomerOrder customerOrder) {
        if (customerOrderService.existe(customerOrder.getId())){
            DtoApiResponse<CustomerOrder> dto = new DtoApiResponse(404, "El producto que intenta guardar ya existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }else{
            DtoApiResponse<CustomerOrder> dto = new DtoApiResponse(200, "", customerOrderService.guardar(customerOrder));
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }
    }

    //METODO PUT
    @PutMapping()
    public ResponseEntity<DtoApiResponse<CustomerOrder>> actualizar(@RequestBody CustomerOrder customerOrder) {
        if (customerOrderService.existe(customerOrder.getId())){
            DtoApiResponse<CustomerOrder> dto = new DtoApiResponse<>(200, "", customerOrderService.guardar(customerOrder));
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }else{
            DtoApiResponse dto = new DtoApiResponse(404, "", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
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
