package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.CustomerOrder;
import com.libreria_pedidos.libreria_api.serviceJPA.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class CustomerOrderController {

    @Autowired
    private ICustomerOrderService customerOrderService;

    //METODO GET
    @GetMapping
    public List<CustomerOrder> buscarTodos() {
        return customerOrderService.buscarTodos();
    }

    //METODO GET BY ID
    @GetMapping("/{id}")
    public CustomerOrder buscarPorId(@PathVariable Long id) {
        return customerOrderService.buscarPorId(id);
    }

    //METODO POST
    @PostMapping
    public CustomerOrder guardar(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.guardar(customerOrder);
    }

    //METODO PUT
    @PutMapping("/{id}")
    public CustomerOrder actualizar(@PathVariable Long id, @RequestBody CustomerOrder customerOrder) {
        return customerOrderService.actualizar(id, customerOrder);
    }

    //METODO DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        customerOrderService.eliminar(id);
    }



}
