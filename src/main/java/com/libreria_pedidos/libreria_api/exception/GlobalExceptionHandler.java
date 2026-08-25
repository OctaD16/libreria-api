package com.libreria_pedidos.libreria_api.exception;

import com.libreria_pedidos.libreria_api.util.DtoApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //errores 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<DtoApiResponse<String>> recursoNoEncontrado(ResourceNotFoundException e){
        DtoApiResponse<String> dto = new DtoApiResponse<>(404, e.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    //errores 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<DtoApiResponse<String>> erroresGenerales(Exception e){
        DtoApiResponse<String> dto = new DtoApiResponse<>(500, e.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
    }
}
