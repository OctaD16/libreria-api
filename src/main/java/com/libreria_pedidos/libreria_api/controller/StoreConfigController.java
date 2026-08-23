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
        if (listaDeStoreConfig == null || listaDeStoreConfig.isEmpty()){
            DtoApiResponse dto = new DtoApiResponse(404, "No hay configuraciones de tienda", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }else {
            DtoApiResponse dto = new DtoApiResponse(200, "Configuraciones encontradas", listaDeStoreConfig);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoApiResponse<StoreConfig>> buscarPorId(@PathVariable Long id) {
        if(storeConfigService.existe(id)){
            DtoApiResponse<StoreConfig> dto = new DtoApiResponse<>(200, "Configuracion encontrada", storeConfigService.buscarPorId(id));
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse dto = new DtoApiResponse(404, "Configuracion no encontrada", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }

    //METODO POST
    @PostMapping
    public ResponseEntity<DtoApiResponse<StoreConfig>> guardar(@RequestBody StoreConfig storeConfig) {
        if (storeConfigService.existe(storeConfig.getId())){
            DtoApiResponse<StoreConfig> dto = new DtoApiResponse<>(404, "La configuracion que intenta guardar ya existe", null );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }else{
            DtoApiResponse<StoreConfig> dto = new DtoApiResponse<>(200, "Configuracion creada correctamente", storeConfigService.guardar(storeConfig));
            return ResponseEntity.ok().body(dto);
        }
    }

    //METODO PUT
    @PutMapping()
    public ResponseEntity<DtoApiResponse<StoreConfig>> actualizar(@RequestBody StoreConfig storeConfig) {
        if (storeConfigService.existe(storeConfig.getId())){
            DtoApiResponse<StoreConfig> dto = new DtoApiResponse<>(200, "Configuracion actualizada correctamente", storeConfigService.guardar(storeConfig));
            return ResponseEntity.ok().body(dto);
        }else{
            DtoApiResponse<StoreConfig> dto = new DtoApiResponse<>(404, "La configuracion que intenta actualizar no existe", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<DtoApiResponse<?>> controladorDeExcepciones(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.add(violation.getMessage());
        }
        DtoApiResponse<?> response = new DtoApiResponse<>(400, errors, null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
