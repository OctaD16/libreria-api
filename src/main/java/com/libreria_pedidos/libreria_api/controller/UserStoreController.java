package com.libreria_pedidos.libreria_api.controller;


import com.libreria_pedidos.libreria_api.model.UserStore;
import com.libreria_pedidos.libreria_api.service.UserStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-store")
public class UserStoreController {
    @Autowired
    private UserStoreService userStoreService;

    //METODO GET
    @GetMapping
    public List<UserStore> buscarTodos() {
        return userStoreService.buscarTodos();
    }

    //METODO GET BY ID
    @GetMapping("/{id}")
    public UserStore buscarPorId(@PathVariable Long id) {
        return userStoreService.buscarPorId(id);
    }

    //METODO POST
    @PostMapping
    public UserStore guardar(@RequestBody UserStore userStore) {
        return userStoreService.guardar(userStore);
    }

    //METODO PUT
    @PutMapping
    public UserStore actualizar(@PathVariable Long id, @RequestBody UserStore userStore) {
        return userStoreService.actualizar(id, userStore);
    }

    //METODO DELETE
    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        userStoreService.eliminar(id);
    }
}
