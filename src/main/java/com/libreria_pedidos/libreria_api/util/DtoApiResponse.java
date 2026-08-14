package com.libreria_pedidos.libreria_api.util;

import java.util.ArrayList;
import java.util.List;

public class DtoApiResponse <T> {
    private int status;
    private List<String> message;
    private T data;



    //contructor de multiples mensajes
    public DtoApiResponse(int status, List<String> message, T data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //constructor de un solo mensaje
    public DtoApiResponse(int status, String message, T data) {
        super();
        this.status = status;
        List<String> messages = new ArrayList<String>();
        messages.add(message);
        this.message = messages;
        this.data = data;
    }

    public DtoApiResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
