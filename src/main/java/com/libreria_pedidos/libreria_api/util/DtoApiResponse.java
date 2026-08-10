package com.libreria_pedidos.libreria_api.util;

import java.util.List;

public class DtoApiResponse <T> {
    private String message;
    private List<String> errors;
    private T data;

    public DtoApiResponse(String message, List<String> errors, T data) {
        super();
        this.message = message;
        this.errors = errors;
        this.data = data;
    }

    

}
