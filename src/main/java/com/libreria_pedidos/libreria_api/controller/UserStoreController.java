package com.libreria_pedidos.libreria_api.controller;


import com.libreria_pedidos.libreria_api.model.UserStore;
import com.libreria_pedidos.libreria_api.serviceJPA.IUserStoreService;
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
@RequestMapping("/api/user-store")
public class UserStoreController {
    @Autowired
    private IUserStoreService userStoreService;

    //METODO GET
    @GetMapping
    public ResponseEntity<DtoApiResponse<List<UserStore>>> buscarTodos() {
        List<UserStore> listaDeUserStore = userStoreService.buscarTodos();
        DtoApiResponse<List<UserStore>> response = new DtoApiResponse<>(200, "Usuarios encontrados", listaDeUserStore);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<UserStore>> buscarPorId(@PathVariable Long id) {
        UserStore userStore = userStoreService.buscarPorId(id);
        DtoApiResponse<UserStore> response = new DtoApiResponse<>(200, "Usuario encontrado", userStore);
        return ResponseEntity.ok(response);
    }

    //METODO POST
    @PostMapping
    public ResponseEntity<DtoApiResponse<UserStore>> guardar(@RequestBody UserStore userStore) {
        UserStore usuarioGuardado = userStoreService.guardar(userStore);
        DtoApiResponse<UserStore> response = new DtoApiResponse<>(201, "Usuario guardado", usuarioGuardado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //METODO PUT
    @PutMapping("/{id}")
    public ResponseEntity<DtoApiResponse<UserStore>> actualizar(@RequestBody UserStore userStore, @PathVariable Long id) {
        UserStore usuarioActualizado = userStoreService.actualizar(id, userStore);
        DtoApiResponse<UserStore> response = new DtoApiResponse<>(200, "Usuario actualizado", usuarioActualizado);
        return ResponseEntity.ok(response);
    }

    //METODO DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<DtoApiResponse<UserStore>> eliminar(@PathVariable Long id) {
        if (userStoreService.existe(id)){
            userStoreService.eliminar(id);
            DtoApiResponse<UserStore> dto = new DtoApiResponse<>(200, "Usuario eliminado correctamente", null);
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<UserStore> dto = new DtoApiResponse<>(404, "El usuario que intenta eliminar no existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }
}
