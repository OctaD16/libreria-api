package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.StoreConfig;
import com.libreria_pedidos.libreria_api.service.StoreConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store-config")
public class StoreConfigController {
    @Autowired
    private StoreConfigService storeConfigService;

    //METODO GET
    @GetMapping
    public List<StoreConfig> buscarTodos() {
        return storeConfigService.buscarTodos();
    }

    //METODO GET BY ID
    @GetMapping("/{id}")
    public StoreConfig buscarPorId(@PathVariable Long id) {
        return storeConfigService.buscarPorId(id);
    }

    //METODO POST
    @PostMapping
    public StoreConfig guardar(@RequestBody StoreConfig storeConfig) {
        return storeConfigService.guardar(storeConfig);
    }

    //METODO PUT
    @PutMapping
    public StoreConfig actualizar(@PathVariable Long id, @RequestBody StoreConfig storeConfig) {
        return storeConfigService.actualizar(id, storeConfig);
    }

    //METODO DELETE
    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        storeConfigService.eliminar(id);
    }
}
