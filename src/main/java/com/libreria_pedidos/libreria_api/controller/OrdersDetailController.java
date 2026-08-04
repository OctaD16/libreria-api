package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.OrdersDetail;
import com.libreria_pedidos.libreria_api.serviceJPA.IOrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordersDetail")
public class OrdersDetailController {

    @Autowired
    private IOrdersDetailService ordersDetailService;

    //METODO GET
    @GetMapping
    public List<OrdersDetail> buscarTodos() {
        return ordersDetailService.buscarTodos();
    }

    //METODO GET
    @GetMapping("/{id}")
    public OrdersDetail buscarPorId(@PathVariable Long id) {
        return ordersDetailService.buscarPorId(id);
    }

    //METODO POST
    @PostMapping
    public OrdersDetail guardar(@RequestBody OrdersDetail ordersDetail) {
        return ordersDetailService.guardar(ordersDetail);
    }

    //METODO PUT
    @PutMapping
    public OrdersDetail actualizar(@PathVariable Long id, @RequestBody OrdersDetail ordersDetail) {
        return ordersDetailService.actualizar(id, ordersDetail);
    }

    //METODO DELETE
    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        ordersDetailService.eliminar(id);
    }


}
