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
        if (listaDeUserStore == null || listaDeUserStore.isEmpty()){
            DtoApiResponse dto = new DtoApiResponse(404, "No hay usuarios de tienda", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }else {
            DtoApiResponse dto = new DtoApiResponse(200, "Usuarios encontrados", listaDeUserStore);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<UserStore>> buscarPorId(@PathVariable Long id) {
        if(userStoreService.existe(id)){
            DtoApiResponse<UserStore> dto = new DtoApiResponse<>(200, "Usuario encontrado", userStoreService.buscarPorId(id));
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse dto = new DtoApiResponse(404, "Usuario no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }

    //METODO POST
    @PostMapping
    public ResponseEntity<DtoApiResponse<UserStore>> guardar(@RequestBody UserStore userStore) {
        if (userStoreService.existe(userStore.getId())){
            DtoApiResponse<UserStore> dto = new DtoApiResponse<>(404, "El usuario que intenta guardar ya existe", null );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }else{
            DtoApiResponse<UserStore> dto = new DtoApiResponse<>(200, "Usuario creado correctamente", userStoreService.guardar(userStore));
            return ResponseEntity.ok().body(dto);
        }
    }

    //METODO PUT
    @PutMapping()
    public ResponseEntity<DtoApiResponse<UserStore>> actualizar(@RequestBody UserStore userStore) {
        if (userStoreService.existe(userStore.getId())){
            DtoApiResponse<UserStore> dto = new DtoApiResponse<>(200, "Usuario actualizado correctamente", userStoreService.guardar(userStore));
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<UserStore> dto = new DtoApiResponse<>(404, "El usuario que intenta actualizar no existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
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
