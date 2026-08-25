package com.libreria_pedidos.libreria_api.controller;

import com.libreria_pedidos.libreria_api.model.StoreConfig;
import com.libreria_pedidos.libreria_api.serviceJPA.IStoreConfigService;
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
@RequestMapping("/api/store-config")
public class StoreConfigController {
    @Autowired
    private IStoreConfigService storeConfigService;

    //METODO GET
    @GetMapping
    public ResponseEntity<DtoApiResponse<List<StoreConfig>>> buscarTodos() {
        List<StoreConfig> listaDeStoreConfig = storeConfigService.buscarTodos();
        DtoApiResponse<List<StoreConfig>> response = new DtoApiResponse<>(200, "Configuraciones encontradas", listaDeStoreConfig);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<StoreConfig>> buscarPorId(@PathVariable Long id) {
        StoreConfig storeConfig = storeConfigService.buscarPorId(id);
        DtoApiResponse<StoreConfig> response = new DtoApiResponse<>(200, "Configuracion encontrada", storeConfig);
        return ResponseEntity.ok(response);
    }

    //METODO POST
    @PostMapping
    public ResponseEntity<DtoApiResponse<StoreConfig>> guardar(@RequestBody StoreConfig storeConfig) {
        StoreConfig configuracionGuardada = storeConfigService.guardar(storeConfig);
        DtoApiResponse<StoreConfig> response = new DtoApiResponse<>(201, "Configuracion guardada", configuracionGuardada);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //METODO PUT
    @PutMapping("/{id}")
    public ResponseEntity<DtoApiResponse<StoreConfig>> actualizar(@RequestBody StoreConfig storeConfig, @PathVariable Long id) {
        StoreConfig configuracionActualizada = storeConfigService.actualizar(id, storeConfig);
        DtoApiResponse<StoreConfig> response = new DtoApiResponse<>(200, "Configuracion actualizada", configuracionActualizada);
        return ResponseEntity.ok(response);
    }

    //METODO DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<DtoApiResponse<StoreConfig>> eliminar(@PathVariable Long id) {
        if (storeConfigService.existe(id)){
            storeConfigService.eliminar(id);
            DtoApiResponse<StoreConfig> dto = new DtoApiResponse<>(200, "Configuracion eliminada correctamente", null);
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<StoreConfig> dto = new DtoApiResponse<>(404, "La configuracion que intenta eliminar no existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }
}
